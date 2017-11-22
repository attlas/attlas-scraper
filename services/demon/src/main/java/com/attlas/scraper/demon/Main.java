package com.attlas.scraper.demon;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

/**
 * Main class.
 *
 */
public class Main {

  private static final Logger logger = Logger.getLogger(Main.class);
  //

  // Base URI the Grizzly HTTP server will listen on
  public static final String BASE_URI;
  private static final String PROTOCOL;
  private static final String DATA_HOME;
  private static final Optional < String > host;
  private static final Optional < String > port;

  static {
    PROTOCOL = "http://";
    host = Optional.ofNullable(System.getenv("DEMON_HOSTNAME"));
    port = Optional.ofNullable(System.getenv("DEMON_PORT"));
    BASE_URI = PROTOCOL + host.orElse("localhost") + ":" + port.orElse("80") + "/";
    DATA_HOME = Optional.ofNullable(System.getenv("DEMON_DATA_HOME")).orElse("./data");
  }

  /**
   * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
   * @return Grizzly HTTP server.
   */
  public static HttpServer createServer() {
    logger.info("Grizzly server URL " + BASE_URI);
    // create a resource config that scans for JAX-RS resources and providers
    // in com.attlas package
    final ResourceConfig rc = new ResourceConfig().packages("com.attlas.scraper.demon");

    // create and start a new instance of grizzly http server
    // exposing the Jersey application at BASE_URI
    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
  }

  /**
   * Main method.
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    //
    logger.info("Initiliazing Grizzly server using " + BASE_URI);
    //
    Process p;
    try {
      //p = Runtime.getRuntime().exec("php ./scripts/vacancies/dou.ua/collect.php");
      p = Runtime.getRuntime().exec("php -v");
      p.waitFor();
      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line = "";
      while ((line = reader.readLine())!= null) {
        logger.info(line);
      }
    } catch (Exception e) {
      logger.error("", e);
    }
    //
    CountDownLatch exitEvent = new CountDownLatch(1);
    HttpServer server = createServer();
    // register shutdown hook
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      logger.info("Stopping server ...");
      server.stop();
      exitEvent.countDown();
    }, "shutdownHook"));

    try {
      server.start();
      logger.info(String.format("Jersey app started with WADL available at %sapplication.wadl", BASE_URI));
      logger.info("Press CTRL^C to exit ...");
      exitEvent.await();
      logger.info("Exiting service ...");
    } catch (InterruptedException e) {
      logger.error("There was an error while starting Grizzly HTTP server.", e);
      Thread.currentThread().interrupt();
    }
  }
}
