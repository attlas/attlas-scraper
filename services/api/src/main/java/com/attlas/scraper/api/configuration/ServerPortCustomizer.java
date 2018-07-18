package com.attlas.scraper.api.configuration;

import com.attlas.scraper.api.constants.AppConst;
import com.attlas.scraper.api.utils.EnvironmentVariablesLoader;
import com.attlas.scraper.api.utils.VarTransfer;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

  private EnvironmentVariablesLoader loader = EnvironmentVariablesLoader.getInstance();
  private VarTransfer transfer = VarTransfer.getInstance();
  private static final String port = "COMPONENT_PARAM_PORT";

  @Override
  public void customize(ConfigurableWebServerFactory factory) {
    factory.setPort(transfer.varAsInteger(loader.receiveEnvironmentVariable(AppConst.PORT)));
  }
}