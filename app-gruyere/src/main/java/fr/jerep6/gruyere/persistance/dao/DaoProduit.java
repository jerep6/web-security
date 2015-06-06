package fr.jerep6.gruyere.persistance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.jerep6.gruyere.persistance.bo.Produit;

@Repository
public class DaoProduit {

  @PersistenceContext
  private EntityManager em;

  public List<Produit> lire() {
    TypedQuery<Produit> query = em.createQuery(
        "SELECT p FROM " + Produit.class.getName() + " p", Produit.class);
    return query.getResultList();
  }

}
