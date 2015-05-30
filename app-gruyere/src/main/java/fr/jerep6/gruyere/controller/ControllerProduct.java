package fr.jerep6.gruyere.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerProduct {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {

    Map<String, String> tplMiddle = new HashMap<>();
    tplMiddle.put("html", "fragments/order");
    tplMiddle.put("frg", "order_create");
    model.addAttribute("tpl_middle", tplMiddle);
    return "index";
  }
}
