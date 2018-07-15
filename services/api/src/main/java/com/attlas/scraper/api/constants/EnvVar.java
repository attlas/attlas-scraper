package com.attlas.scraper.api.constants;

import java.util.Map;
import java.util.TreeMap;

public enum EnvVar {
  COMPONENT_PARAM_HOST,
  COMPONENT_PARAM_LSTN,
  COMPONENT_PARAM_PORT,
  COMPONENT_PARAM_PORTS,
  COMPONENT_PARAM_CORS,
  COMPONENT_PARAM_MONGO_HOST,
  COMPONENT_PARAM_MONGO_PORT;

  private static Map<EnvVar, String> ss = new TreeMap<>();
  private String str;

  static {
    for (int i = 0; i < values().length; i++) {
      values()[i].str = System.getenv(EnvVar.values()[i].toString());
      ss.put(values()[i], values()[i].str);
    }
  }

  public static String fromEnvVar(EnvVar envVar) {
    return ss.get(envVar);
  }

  public String valueString() {
    return str;
  }
}
