package fr.jerep6.gruyere.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CSPReport {
  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @RequestMapping(value = "/csp-report", method = RequestMethod.POST, consumes = "application/json")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void report(@RequestBody String cspData) {

    LOGGER.warn("csp report " + cspData);
  }

}
