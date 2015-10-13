package fr.jerep6.gruyere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.common.base.Strings;

import fr.jerep6.gruyere.persistance.bo.Utilisateur;
import fr.jerep6.gruyere.persistance.dao.DaoProduit;
import fr.jerep6.gruyere.persistance.dao.DaoUtilisateur;
import fr.jerep6.gruyere.transfert.ProduitDTO;

@Controller
@SessionAttributes("utilisateur")
public class ControllerCompteClient {
  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private DaoUtilisateur daoUtilisateur;

  @Autowired
  private DaoProduit daoProduit;

  @RequestMapping(value = "/authentification", method = RequestMethod.GET)
  public String index(Model model, @RequestParam(required = false) String urlCible) {

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/authentification");
    tplMiddle.put("frg", ".authentification");
    model.addAttribute("tpl_middle", tplMiddle);
    model.addAttribute("url_cible", urlCible);
    return "index";
  }

  @RequestMapping(value = "/authentification-process", method = RequestMethod.POST)
  public String connexion(Model model, @RequestParam("login") String login,
      @RequestParam("pwd") String pwd, @RequestParam(required = false) String urlCible) {

    Utilisateur utilisateur = daoUtilisateur.connecter(login, pwd);
    if (utilisateur == null) {
      LOGGER.warn("Login fail");
      return "redirect:/authentification";
    }
    else {
      model.addAttribute("utilisateur", utilisateur);
      Map<String, String> tplMiddle = new HashMap<>();
      tplMiddle.put("html", "fragments/authentification");
      tplMiddle.put("frg", ".authentification");
      model.addAttribute("tpl_middle", tplMiddle);

      return "redirect:" + (Strings.isNullOrEmpty(urlCible) ? "/" : urlCible);
    }

  }

  @RequestMapping(value = "/compte/produits", method = RequestMethod.GET)
  public String listerProduitUtilisateur(Model model,
      @ModelAttribute("utilisateur") Utilisateur utilisateur) {
    List<ProduitDTO> produitsUtilisateur = daoProduit.listerProduitUtilisateur(utilisateur
        .getTechid());

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/produit-compte-client");
    tplMiddle.put("frg", ".produit-list-compte-client");
    model.addAttribute("tpl_middle", tplMiddle);
    model.addAttribute("produits", produitsUtilisateur);

    return "index";
  }

  @RequestMapping(value = "/compte/produits/{produit_id}", method = RequestMethod.GET)
  public String modifierProduit(Model model, @PathVariable("produit_id") Integer produitId,
      @ModelAttribute("utilisateur") Utilisateur utilisateur) {

    ProduitDTO produit = daoProduit.lire(produitId);

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/produit-compte-client");
    tplMiddle.put("frg", ".produit-modication-compte-client");
    model.addAttribute("tpl_middle", tplMiddle);
    model.addAttribute("produit", produit);

    return "index";
  }
}
