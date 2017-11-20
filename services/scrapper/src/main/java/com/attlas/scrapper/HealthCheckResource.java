package com.attlas.scrapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


import org.apache.log4j.Logger;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("healthcheck")
public class HealthCheckResource {

  private static final Logger logger = Logger.getLogger(HealthCheckResource.class);
  /**
   * Method handling HTTP GET requests. The returned object will be sent
   * to the client as "text/plain" media type.
   *
   * @return String that will be returned as a text/plain response.
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getIt(@Context UriInfo uriInfo) {
    logger.info(uriInfo.getRequestUri());
    return "Live";
  }
}
