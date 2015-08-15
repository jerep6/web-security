package fr.jerep6.gruyere.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

public class CSPInterceptor extends HandlerInterceptorAdapter {
  private Map<String, List<String>> config = new HashMap<>();

  public CSPInterceptor() {
    List<String> scriptSrc = new ArrayList<>();
    scriptSrc.add("'self'");

    List<String> styleSrc = new ArrayList<>();
    styleSrc.add("'self'");

    List<String> imgSrc = new ArrayList<>();
    imgSrc.add("'self'");

    List<String> reportUri = new ArrayList<>();
    reportUri.add("/csp-report");

    config.put("script-src", scriptSrc);
    config.put("style-src", styleSrc);
    config.put("img-src", imgSrc);
    config.put("report-uri", reportUri);

  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    String cspParam = request.getParameter("csp");
    if (!Strings.isNullOrEmpty(cspParam)) {
      StringBuilder csp = new StringBuilder();
      for (Entry<String, List<String>> e : config.entrySet()) {
        csp.append(e.getKey() + " " + Joiner.on(" ").join(e.getValue()) + "; ");
      }
      response.addHeader("Content-Security-Policy", csp.toString());
    }
  }
}
