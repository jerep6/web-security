package fr.jerep6.gruyere.persistance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import fr.jerep6.gruyere.persistance.bo.Commentaire;
import fr.jerep6.gruyere.persistance.bo.Produit;
import fr.jerep6.gruyere.persistance.bo.Utilisateur;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class DaoProduit {

  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @PersistenceContext
  private EntityManager em;

  public List<Produit> listerTousLesProduits() {
    TypedQuery<Produit> query = em.createQuery("SELECT p FROM " + Produit.class.getName() + " p",
        Produit.class);
    return query.getResultList();
  }

  public List<Produit> listerProduitUtilisateur(Utilisateur utilisateur) {
    Preconditions.checkNotNull(utilisateur);
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT p FROM " + Produit.class.getName() + " p");
    sb.append(" WHERE p.proprietaire.id =:UTI_ID");

    LOGGER.debug("JPQL : {}", sb.toString());
    TypedQuery<Produit> query = em.createQuery(sb.toString(), Produit.class);
    query.setParameter("UTI_ID", utilisateur.getTechid());

    return query.getResultList();
  }

  public Produit lire(Integer produitId) {
    Preconditions.checkNotNull(produitId);

    StringBuilder sb = new StringBuilder();
    sb.append("SELECT distinct p FROM " + Produit.class.getName() + " p");
    sb.append(" LEFT JOIN FETCH p.commentaires");
    sb.append(" JOIN FETCH p.proprietaire");
    sb.append(" WHERE p.techid =:PRD_ID");

    LOGGER.debug("JPQL : {}", sb.toString());
    TypedQuery<Produit> query = em.createQuery(sb.toString(), Produit.class);
    query.setParameter("PRD_ID", produitId);

    return query.getSingleResult();
  }

  public void posterQuestion(Utilisateur utilisateur, Integer produitId, String question) {
    Preconditions.checkNotNull(utilisateur);
    Preconditions.checkNotNull(produitId);
    Preconditions.checkArgument(!Strings.isNullOrEmpty(question));

    Commentaire com = new Commentaire();
    com.setContenu(question);
    com.setProduit(lire(produitId));
    com.setUtilisateur(utilisateur);

    em.persist(com);
    em.flush();

  }

}
