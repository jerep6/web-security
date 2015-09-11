package fr.jerep6.gruyere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.jerep6.gruyere.persistance.bo.Produit;
import fr.jerep6.gruyere.persistance.bo.Utilisateur;
import fr.jerep6.gruyere.persistance.dao.DaoProduit;
import fr.jerep6.gruyere.transfert.ProduitDTO;

@Controller
@SessionAttributes("utilisateur")
public class ControllerProduit {
  @Autowired
  private DaoProduit daoProduit;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {

    List<Produit> produits = daoProduit.listerTousLesProduits();

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/produit-catalogue");
    tplMiddle.put("frg", ".produit-list-catalogue");
    model.addAttribute("tpl_middle", tplMiddle);
    model.addAttribute("produits", produits);
    return "index";
  }

  @RequestMapping(value = "/produits/{produit_id}", method = RequestMethod.GET)
  public String lire(Model model, @PathVariable("produit_id") Integer produitId) {

    Produit produit = daoProduit.lire(produitId);

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/produit-catalogue");
    tplMiddle.put("frg", ".produit-detail-catalogue");
    model.addAttribute("tpl_middle", tplMiddle);
    model.addAttribute("produit", produit);

    return "index";
  }

  @RequestMapping(value = "/produits", method = RequestMethod.GET)
  public String listerProduitUtilisateur(Model model, @RequestParam("u") String utilisateurId) {
    List<ProduitDTO> produitsUtilisateur = daoProduit.listerProduitUtilisateur(utilisateurId);

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/produit-catalogue");
    tplMiddle.put("frg", ".produit-list-catalogue");
    model.addAttribute("tpl_middle", tplMiddle);
    model.addAttribute("produits", produitsUtilisateur);

    return "index";
  }

  @RequestMapping(value = "/produits/{produit_id}/questions", method = RequestMethod.POST)
  public String posterQuestion(Model model, @PathVariable("produit_id") Integer produitId,
      @RequestParam("question") String question,
      @ModelAttribute("utilisateur") Utilisateur utilisateur) {

    daoProduit.posterQuestion(utilisateur, produitId, question);

    return "redirect:/produits/" + produitId;
  }

}
