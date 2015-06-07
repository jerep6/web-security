package fr.jerep6.gruyere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.jerep6.gruyere.persistance.bo.Produit;
import fr.jerep6.gruyere.persistance.dao.DaoProduit;

@Controller
@SessionAttributes("utilisateur")
public class ControllerProduct {
  @Autowired
  private DaoProduit daoProduit;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {

    List<Produit> produits = daoProduit.lire();

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/produit-liste");
    tplMiddle.put("frg", ".produit-list");
    model.addAttribute("tpl_middle", tplMiddle);
    model.addAttribute("produits", produits);
    return "index";
  }
}
