package com.attlas.scraper.demon;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;

public class HealthCheckResourceTest {

  private static final Logger logger = Logger.getLogger(HealthCheckResourceTest.class);

  private HttpServer server;
  private WebTarget target;

  @Before
  public void setUp() throws Exception {
    // start the server
    server = Main.createServer();
    server.start();
    // create the client
    Client c = ClientBuilder.newClient();

    // uncomment the following line if you want to enable
    // support for JSON in the client (you also have to uncomment
    // dependency on jersey-media-json module in pom.xml and Main.startServer())
    // --
    // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

    target = c.target(Main.BASE_URI);
  }

  @After
  public void tearDown() throws Exception {
    server.stop();
  }

  /**
   * Test to see that the message "Live" is sent in the response.
   */
  @Test
  public void testGetIt() {
    String responseMsg = target.path("healthcheck").request().get(String.class);
    assertEquals("Live", responseMsg);
  }
}
