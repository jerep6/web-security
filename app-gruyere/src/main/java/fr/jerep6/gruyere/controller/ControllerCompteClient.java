package fr.jerep6.gruyere.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.jerep6.gruyere.persistance.bo.Utilisateur;
import fr.jerep6.gruyere.persistance.dao.DaoUtilisateur;

@Controller
@SessionAttributes("utilisateur")
public class ControllerCompteClient {
  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private DaoUtilisateur daoUtilisateur;

  @RequestMapping(value = "/authentification", method = RequestMethod.GET)
  public String index(Model model) {

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/authentification");
    tplMiddle.put("frg", ".authentification");
    model.addAttribute("tpl_middle", tplMiddle);
    return "index";
  }

  @RequestMapping(value = "/authentification-process", method = RequestMethod.POST)
  public String connexion(Model model, @RequestParam("login") String login,
      @RequestParam("pwd") String pwd) {

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
      return "redirect:/";
    }

  }
}
