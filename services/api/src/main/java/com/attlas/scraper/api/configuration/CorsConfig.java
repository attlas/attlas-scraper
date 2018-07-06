package com.attlas.scraper.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

  @Value("${COMPONENT_PARAM_CORS}")
  private String COMPONENT_PARAM_CORS;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/"+COMPONENT_PARAM_CORS);
  }
}
