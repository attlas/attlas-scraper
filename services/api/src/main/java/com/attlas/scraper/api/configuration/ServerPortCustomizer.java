package com.attlas.scraper.api.configuration;

import com.attlas.scraper.api.utils.EnvironmentVariablesLoader;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

  private EnvironmentVariablesLoader loader = EnvironmentVariablesLoader.getInstance();
  private final static String componentParamPort = "COMPONENT_PARAM_PORT";

  @Override
  public void customize(ConfigurableWebServerFactory factory) {
    factory.setPort(Integer.parseInt(Optional.ofNullable(loader.receiveEnvironmentVariable(componentParamPort)).orElse("9000")));
  }
}