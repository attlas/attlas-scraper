package com.attlas.scraper.demon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Optional;
import org.apache.log4j.Logger;

/**
 * Main class.
 *
 */
public class Storage {
  //
  private static final Logger logger = Logger.getLogger(Storage.class);

  //
  private static final String DEMON_DATA_HOME;

  static {
    DEMON_DATA_HOME = Optional.ofNullable(System.getenv("DEMON_DATA_HOME")).orElse("/data");
  }

  /**
   */
  public static String getDemonDataHome() {
    return DEMON_DATA_HOME;
  }

  /**
   */
  public static boolean exec(final String command){
    logger.info("[+] Executing: " + command);
    int exitVal = -1;
    try {
      Process p = Runtime.getRuntime().exec(command);
      exitVal = p.waitFor();
      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line = "";
      while ((line = reader.readLine())!= null) {
        logger.info(" | " + line);
      }
    } catch (Exception e) {
      logger.error("Execution error", e);
    }
    logger.info("[-]");
    return (exitVal == 0);
  }

}
