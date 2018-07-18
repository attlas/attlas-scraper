package com.attlas.scraper.api.configuration;

import com.attlas.scraper.api.constants.AppConst;
import com.attlas.scraper.api.utils.EnvironmentVariablesLoader;
import com.attlas.scraper.api.utils.VarTransfer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsCustomizer implements WebMvcConfigurer {

  private EnvironmentVariablesLoader loader = EnvironmentVariablesLoader.getInstance();
  private VarTransfer transfer = VarTransfer.getInstance();

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/" + transfer.varAsString(loader.receiveEnvironmentVariable(AppConst.CORS)));
  }


}
