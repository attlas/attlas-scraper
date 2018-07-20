package com.attlas.scraper.api.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.attlas.scraper.api.ApplicationParameter;
import com.attlas.scraper.api.Context;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

  private static final Logger logger = LoggerFactory.getLogger(ServerPortCustomizer.class);

  @Override
  public void customize(ConfigurableWebServerFactory factory) {
    final int port = Context.getInstance().asInt(ApplicationParameter.PORT);
    factory.setPort(port);
  }
}