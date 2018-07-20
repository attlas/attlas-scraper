package com.attlas.scraper.api.configuration;

import com.attlas.scraper.api.ApplicationParameter;
import com.attlas.scraper.api.Context;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsCustomizer implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/" + Context.getInstance().asString(ApplicationParameter.CORS));
  }


}
