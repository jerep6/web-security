package fr.jerep6.evil.model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;

public class EvilCookie {
  private Date date = new Date();
  private List<Cookie> cookies;

  public EvilCookie(String rawCookies) {

    cookies = Arrays.asList(rawCookies.split("; ")).stream().map(c -> {
      String[] s = c.split("=");
      return new Cookie(s[0], s[1]);
    }).collect(Collectors.toList());

  }

  public String getFormatedDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.format(date);
  }

  public List<Cookie> getCookies() {
    return cookies;
  }

}
