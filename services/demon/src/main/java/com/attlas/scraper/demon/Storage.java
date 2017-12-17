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
  private static final String TOR_HOST;
  private static final String TOR_SOCKS_PORT;

  static {
    DEMON_DATA_HOME = Optional.ofNullable(System.getenv("DEMON_DATA_HOME")).orElse("/data");
    TOR_HOST = Optional.ofNullable(System.getenv("TOR_HOST")).orElse("127.0.0.1");
    TOR_SOCKS_PORT = Optional.ofNullable(System.getenv("TOR_SOCKS_PORT")).orElse("9050");
  }

  /**
   */
  public static String getDemonDataHome() {
    return DEMON_DATA_HOME;
  }

  /**
   */
  public static String getTorHost() {
    return TOR_HOST;
  }

  /**
   */
  public static String getTorSocksPort() {
    return TOR_SOCKS_PORT;
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
