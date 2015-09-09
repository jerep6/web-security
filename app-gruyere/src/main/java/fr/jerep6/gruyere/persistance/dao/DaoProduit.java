package fr.jerep6.gruyere.persistance.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
import fr.jerep6.gruyere.transfert.ProduitDTO;

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

  public List<ProduitDTO> listerProduitUtilisateur(String utilisateurId) {
    // utilisateurId =
    // "1' UNION SELECT UTI_ID, UTI_LOGIN, UTI_PWD, 1.0, '/resources/img/pirate.png' FROM UTILISATEUR WHERE '1'='1";

    Preconditions.checkNotNull(utilisateurId);
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX, PRD_IMAGE FROM PRODUIT p");
    sb.append(" WHERE UTI_ID ='" + utilisateurId + "'");

    LOGGER.debug("JPQL : {}", sb.toString());
    Query query = em.createNativeQuery(sb.toString());

    List<ProduitDTO> produits = ((List<Object>) query.getResultList()).stream()
        .map(this::mapProduit).collect(Collectors.toList());

    return produits;
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

  private ProduitDTO mapProduit(Object result) {
    Object[] o = (Object[]) result;
    ProduitDTO p = new ProduitDTO();

    p.setTechid((Integer) o[0]);
    p.setTitre((String) o[1]);
    p.setDescription((String) o[2]);
    p.setPrix(((Double) o[3]).toString());
    p.setImage((String) o[4]);
    return p;
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
