package fr.jerep6.evil;

// DEBUG WITH JETTY http://clickonchris.com/2010/05/configuring-jetty-maven-and-eclipse-together-with-hot-deploy/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@ComponentScan("fr.jerep6.evil")
// http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

  /** Serve statics resources (css, images, js; ...) */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  // Need to register SpringTemplateEngine separately in order to i18n works
  @Bean
  public SpringTemplateEngine templateEngine() {
    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
    templateResolver.setCacheable(false);
    templateResolver.setPrefix("/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("HTML5");

    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);
    return templateEngine;
  }

  @Bean
  public ViewResolver viewResolver() {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine());
    viewResolver.setCharacterEncoding("UTF-8");
    viewResolver.setOrder(1);
    return viewResolver;
  }

}
