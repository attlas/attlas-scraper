package com.attlas.scraper.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.attlas.scraper.api.ApplicationParameter;
import com.attlas.scraper.api.EnvironmentVariable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Context {

  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  // singleton
  private static volatile Context context = null;

  // list of values from environment variables 
  private Map<String, String> variables = new HashMap<>();

  private Context() {
    // load application parameters from environmetn variables
    for (EnvironmentVariable variable: EnvironmentVariable.values()) {
      final String variableName = variable.toString();
      final String parameterName = variable.getApplicationParameter().toString();
      String value = System.getenv(variableName);
      if (value == null) {
        value = variable.getApplicationParameter().getDefaultValue();
        logger.warn(String.format("Environment variable %s(%s) was not found, default value will be used: %s", variableName, parameterName, value));
      }
      this.variables.put(parameterName, value);
    }
  }

  public static Context getInstance() {
    if (context == null) {
      synchronized (Context.class) {
        if (context == null) {
          context = new Context();
        }
      }
    }
    return context;
  }

  public String asString(final ApplicationParameter parameter) {
    return Optional.ofNullable(this.variables.get(parameter.toString())).orElse(parameter.getDefaultValue());
  }

  public int asInt(final ApplicationParameter parameter) {
    return Integer.parseInt(asString(parameter));
  }

}
