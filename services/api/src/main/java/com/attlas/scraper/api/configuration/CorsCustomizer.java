package com.attlas.scraper.api.configuration;

import com.attlas.scraper.api.utils.EnvironmentVariablesLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

@Configuration
@EnableWebMvc
public class CorsCustomizer implements WebMvcConfigurer {

  private EnvironmentVariablesLoader loader = EnvironmentVariablesLoader.getInstance();
  private static final String COMPONENT_PARAM_CORS = "COMPONENT_PARAM_CORS";

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/" + Optional.ofNullable(loader.receiveEnvironmentVariable(COMPONENT_PARAM_CORS)).orElse("**"));
  }


}
