package com.attlas.scraper.api;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ComponentScan("com.attlas.scraper.api.configuration")
@SpringBootApplication
public class Application {

  private static class ConfMap {

    protected Map<String, Object> confMap () {
      Map<String, Object> map = new HashMap<>();
      String tempEnv = System.getenv("COMPONENT_PARAM_PORT");
      System.out.println(tempEnv);
      String component_param_port = Optional.ofNullable(System.getenv("COMPONENT_PARAM_PORT")).orElse("9999");
      map.put("server.port", component_param_port);
      return map;
    }
  }

  public static void main(String[] args) {
    new SpringApplicationBuilder()
        .bannerMode(Banner.Mode.OFF)
        .sources(Application.class)
        .properties(new ConfMap().confMap())
        .run(args);

  }
}
