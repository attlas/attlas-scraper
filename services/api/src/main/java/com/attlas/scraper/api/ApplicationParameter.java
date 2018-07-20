package com.attlas.scraper.api;

public enum ApplicationParameter {
  HOST("localhost"),
  LSTN("0.0.0.0"),
  PORT("8080"),
  PORTS("8443"),
  CORS("**"),
  MONGO_HOST("localhost"),
  MONGO_PORT("27017");

  private final String defaultValue;

  ApplicationParameter(final String value) {
    this.defaultValue = value;
  }

  public String getDefaultValue() {
    return this.defaultValue;
  }

}
