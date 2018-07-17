package com.attlas.scraper.api.utils;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentVariablesLoader {

  private volatile static EnvironmentVariablesLoader environmentVariablesLoader;

  private Map<String, String> environmentMap;
  private EnvironmentVariablesLoader() {
    this.environmentMap = new HashMap<>();
  }

  private String[] environmentVariablesName = {"COMPONENT_PARAM_HOST", "COMPONENT_PARAM_LSTN", "COMPONENT_PARAM_PORT",
  "COMPONENT_PARAM_PORTS", "COMPONENT_PARAM_CORS", "COMPONENT_PARAM_MONGO_HOST", "COMPONENT_PARAM_MONGO_PORT"};

  public static EnvironmentVariablesLoader getInstance() {
    if (environmentVariablesLoader == null) {
      synchronized (EnvironmentVariablesLoader.class) {
        if (environmentVariablesLoader == null) {
          environmentVariablesLoader = new EnvironmentVariablesLoader();
        }
      }
    }
    return environmentVariablesLoader;
  }

  public String receiveEnvironmentVariable(String envVar) {

    String envVarTemp = envVar;

    for(String environmentVariable : environmentVariablesName) {
      environmentMap.put(environmentVariable, System.getenv(environmentVariable));
    }
    return environmentMap.get(envVarTemp);
  }

}
