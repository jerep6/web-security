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
import fr.jerep6.gruyere.transfert.CommentaireDTO;
import fr.jerep6.gruyere.transfert.ProduitDTO;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class DaoProduit {

  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @PersistenceContext
  private EntityManager em;

  public List<ProduitDTO> listerTousLesProduits() {
    return listerProduitCategorie(null);
  }

  public List<ProduitDTO> listerProduitCategorie(String categorieName) {
    // utilisateurId =
    // "bijou' UNION SELECT UTI_ID, UTI_LOGIN, UTI_PWD, 1.0, '/resources/img/pirate.png', 'hack', UTI_ID, UTI_LOGIN FROM UTILISATEUR WHERE '1'='1";

    StringBuilder sb = new StringBuilder();
    sb.append("SELECT PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX, PRD_IMAGE, PRD_CATEGORIE, U.UTI_ID, u.UTI_LOGIN FROM PRODUIT p");
    sb.append(" JOIN UTILISATEUR u ON u.UTI_ID = p.UTI_ID");
    if (!Strings.isNullOrEmpty(categorieName)) {
      sb.append(" WHERE PRD_CATEGORIE ='" + categorieName + "'");
    }

    LOGGER.debug("JPQL : {}", sb.toString());
    Query query = em.createNativeQuery(sb.toString());

    List<ProduitDTO> produits = ((List<Object>) query.getResultList()).stream()
        .map(this::mapProduit).collect(Collectors.toList());

    return produits;
  }

  public List<ProduitDTO> listerProduitUtilisateur(Integer utilisateurId) {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX, PRD_IMAGE, PRD_CATEGORIE, U.UTI_ID, u.UTI_LOGIN FROM PRODUIT p");
    sb.append(" JOIN UTILISATEUR u ON u.UTI_ID = p.UTI_ID");
    if (utilisateurId != null) {
      sb.append(" WHERE u.UTI_ID ='" + utilisateurId + "'");
    }

    LOGGER.debug("JPQL : {}", sb.toString());
    Query query = em.createNativeQuery(sb.toString());

    List<ProduitDTO> produits = ((List<Object>) query.getResultList()).stream()
        .map(this::mapProduit).collect(Collectors.toList());

    return produits;
  }

  public ProduitDTO lire(Integer produitId) {
    Preconditions.checkNotNull(produitId);

    StringBuilder produit = new StringBuilder();
    produit.append("SELECT distinct new " + ProduitDTO.class.getName());
    produit
    .append("(p.techid, p.titre, p.description, p.prix, p.image, p.categorie, u.techid, u.login)");
    produit.append(" FROM " + Produit.class.getName() + " p");
    produit.append(" JOIN p.proprietaire u");
    produit.append(" WHERE p.techid =:PRD_ID");

    LOGGER.debug("JPQL : {}", produit.toString());
    TypedQuery<ProduitDTO> queryProduit = em.createQuery(produit.toString(), ProduitDTO.class);
    queryProduit.setParameter("PRD_ID", produitId);
    return queryProduit.getSingleResult();
  }

  public List<CommentaireDTO> lireCommentaires(Integer produitId) {
    Preconditions.checkNotNull(produitId);

    StringBuilder commentaires = new StringBuilder();
    commentaires.append("SELECT  new " + CommentaireDTO.class.getName());
    commentaires.append("(c.techid, c.contenu, u.techid, u.login)");
    commentaires.append(" FROM " + Commentaire.class.getName() + " c");
    commentaires.append(" JOIN c.utilisateur u");
    commentaires.append(" WHERE c.produit.techid =:PRD_ID");

    LOGGER.debug("JPQL : {}", commentaires.toString());
    TypedQuery<CommentaireDTO> queryProduit = em.createQuery(commentaires.toString(),
        CommentaireDTO.class);
    queryProduit.setParameter("PRD_ID", produitId);
    return queryProduit.getResultList();
  }

  private ProduitDTO mapProduit(Object result) {
    Object[] o = (Object[]) result;
    ProduitDTO p = new ProduitDTO();

    if (o[0] != null) {
      p.setTechid((Integer) o[0]);
    }
    if (o[1] != null) {
      p.setTitre((String) o[1]);
    }
    if (o[2] != null) {
      p.setDescription((String) o[2]);
    }
    if (o[3] != null) {
      p.setPrix(((Double) o[3]).toString());
    }
    if (o[4] != null) {
      p.setImage((String) o[4]);
    }
    if (o[5] != null) {
      p.setCategorie((String) o[5]);
    }
    if (o[6] != null) {
      p.setUtilisateurId((Integer) o[6]);
    }
    if (o[7] != null) {
      p.setUtilisateurLogin((String) o[7]);
    }
    return p;
  }

  public void posterQuestion(Utilisateur utilisateur, Integer produitId, String question) {
    Preconditions.checkNotNull(utilisateur);
    Preconditions.checkNotNull(produitId);
    Preconditions.checkArgument(!Strings.isNullOrEmpty(question));

    Commentaire com = new Commentaire();
    com.setContenu(question);
    com.setProduit(em.find(Produit.class, produitId));
    com.setUtilisateur(utilisateur);

    em.persist(com);
    em.flush();
  }

}
