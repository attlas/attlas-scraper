package com.attlas.scraper.api.utils;

import com.attlas.scraper.api.constants.AppConst;
import com.attlas.scraper.api.constants.EnvVar;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EnvironmentVariablesLoader {

  private static volatile EnvironmentVariablesLoader environmentVariablesLoader;

  private EnvironmentVariablesLoader() {  }

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

  public String receiveEnvironmentVariable(AppConst appConst) {
    Map<String, String> tempMapOfVar = new HashMap<>();
    for (EnvVar current : EnvVar.values()) {
      tempMapOfVar.put(current.getCorrespond().toString(), System.getenv(current.toString()));
    }
    return Optional.ofNullable(tempMapOfVar.get(appConst.toString())).orElse(appConst.getDefVal());
  }
}
