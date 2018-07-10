package com.attlas.scraper.api;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    //PropertiesUtil.initProperties();
    new SpringApplicationBuilder()
        .bannerMode(Banner.Mode.OFF)
        .sources(Application.class)
        .run(args);
  }
}
