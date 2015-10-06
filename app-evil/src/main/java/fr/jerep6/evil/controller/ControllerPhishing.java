package fr.jerep6.evil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerPhishing {

  @RequestMapping(value = "/phishing", method = RequestMethod.GET)
  public String index(Model model) {
    return "phishing";
  }

}
