package fr.jerep6.gruyere.persistance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;

import fr.jerep6.gruyere.persistance.bo.Utilisateur;

@Repository
public class DaoUtilisateur {
  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @PersistenceContext
  private EntityManager em;

  public Utilisateur connecter(String login, String password) {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT u FROM " + Utilisateur.class.getName() + " u");
    sb.append(" WHERE pwd='" + password + "'");
    sb.append(" AND login='" + login + "'");

    LOGGER.debug("JPQL : {}", sb.toString());
    TypedQuery<Utilisateur> query = em.createQuery(sb.toString(),
        Utilisateur.class);

    List<Utilisateur> resultList = query.getResultList();
    LOGGER.debug("Utilisateurs récupérés : {}", resultList);

    return Iterables.getFirst(resultList, null);
  }
}
