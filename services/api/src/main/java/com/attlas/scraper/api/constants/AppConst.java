package com.attlas.scraper.api.constants;

public enum AppConst {
  HOST("localhost"),
  LSTN("0.0.0.0"),
  PORT("8080"),
  PORTS("80443"),
  CORS("**"),
  MONGO_HOST("localhost"),
  MONGO_PORT("27017");

  private String defVal;

  AppConst() {}

  AppConst(String defVal) {
    this.defVal = defVal;
  }

  public String getDefVal() {
    return defVal;
  }

}
