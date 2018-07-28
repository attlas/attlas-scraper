package com.attlas.scraper.api;

public enum EnvironmentVariable {
  COMPONENT_PARAM_HOST(ApplicationParameter.HOST),
  COMPONENT_PARAM_LSTN(ApplicationParameter.LSTN),
  COMPONENT_PARAM_PORT(ApplicationParameter.PORT),
  COMPONENT_PARAM_PORTS(ApplicationParameter.PORTS),
  COMPONENT_PARAM_CORS(ApplicationParameter.CORS),
  COMPONENT_PARAM_MONGO_HOST(ApplicationParameter.MONGO_HOST),
  COMPONENT_PARAM_MONGO_PORT(ApplicationParameter.MONGO_PORT),
  COMPONENT_PARAM_MONGO_DB(ApplicationParameter.MONGO_DB);

  private final ApplicationParameter applicationParameter;

  EnvironmentVariable(final ApplicationParameter parameter) {
    this.applicationParameter = parameter;
  }

  public ApplicationParameter getApplicationParameter() {
    return this.applicationParameter;
  }

}
