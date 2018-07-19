package com.attlas.scraper.api.constants;

public enum EnvVar {
  COMPONENT_PARAM_HOST(AppConst.HOST),
  COMPONENT_PARAM_LSTN(AppConst.LSTN),
  COMPONENT_PARAM_PORT(AppConst.PORT),
  COMPONENT_PARAM_PORTS(AppConst.PORTS),
  COMPONENT_PARAM_CORS(AppConst.CORS),
  COMPONENT_PARAM_MONGO_HOST(AppConst.MONGO_HOST),
  COMPONENT_PARAM_MONGO_PORT(AppConst.MONGO_PORT);

  private AppConst correspond;

  EnvVar(AppConst correspond) {
    this.correspond = correspond;
  }

  public AppConst getCorrespond(){
    return correspond;
  }
}
