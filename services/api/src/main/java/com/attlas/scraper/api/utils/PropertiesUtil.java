package com.attlas.scraper.api.utils;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Optional;

public class PropertiesUtil {

  private static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

  public static void initProperties() {
    String activeProfile = Optional.ofNullable(System.getProperty(SPRING_PROFILES_ACTIVE)).orElse("dev");

    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
        new PropertySourcesPlaceholderConfigurer();

    Resource[] resources = new ClassPathResource [] {
      new ClassPathResource("application.properties"),
        new ClassPathResource("application." + activeProfile + ".properties")
    };

    propertySourcesPlaceholderConfigurer.setLocations(resources);
  }
}
