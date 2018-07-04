package com.attlas.scraper.api.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringBootServerPortConfig implements CommandLineRunner {

  @Value("$(COMPONENT_PARAM_PORT)")
  private String COMPONENT_PARAM_PORT;

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public void run(String... args) throws Exception {
    new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
      @Override
      public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(Integer.parseInt(COMPONENT_PARAM_PORT));
      }
    };
  }
}
