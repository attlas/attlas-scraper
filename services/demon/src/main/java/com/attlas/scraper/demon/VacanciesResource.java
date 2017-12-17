package com.attlas.scraper.demon;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.PathSegment;

import org.apache.log4j.Logger;

import com.attlas.scraper.demon.ApiResponse;
import com.attlas.scraper.demon.Storage;

/**
 */
@Path("/docs/vacancies")
public class VacanciesResource {

  private static final Logger logger = Logger.getLogger(VacanciesResource.class);

  /**
   * Update general data source company information
   */
  @POST
  @Path("/{companies}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateVacanciesByCompanies(@Context UriInfo uriInfo, @PathParam("companies") String companies) {
    logger.info(uriInfo.getRequestUri());
    //
    if (Storage.exec("php ./scripts/vacancies/"+companies+"/post.php " + Storage.getDemonDataHome() + "/" + uriInfo.getPath())) {
      return Response.ok().entity(ApiResponse.build()).build();
    }
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
  }

  /**
   * Export data from specific source(company) for specific date
   */
  @POST
  @Path("/{companies}/{date}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateVacanciesByCompaniesAndDate(@Context UriInfo uriInfo, @PathParam("companies") String companies, @PathParam("date") String date) {
    logger.info(uriInfo.getRequestUri());
    List<PathSegment> segments = uriInfo.getPathSegments();
    // remove date from path
    String companyHome = segments.get(0).getPath();
    for(int i = 1; i < segments.size() - 1; i++){
      companyHome += "/" + segments.get(i).getPath();
    }
    //
    Storage.exec("pwd");
    if (Storage.exec("php ./scripts/vacancies/" + companies+"/export.php " +
                                                  Storage.getDemonDataHome() + "/" + companyHome + " " +
                                                  date + " " +
                                                  Storage.getTorHost() + " " +
                                                  Storage.getTorSocksPort()
      )) {
      return Response.ok().entity(ApiResponse.build()).build();
    }
    //
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
  }

  /**
   */
  @GET
  @Path("/{companies}/{dates}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacanciesByCompaniesAndDates(@Context UriInfo uriInfo, @PathParam("companies") String companies, @PathParam("dates") String dates) {
    logger.info(uriInfo.getRequestUri());
    //
    List<Object> objList = new ArrayList<>();
    objList.add("Random String");
    objList.add(121); //int
    objList.add(1.22); //double
    objList.add(false); //boolean
    return Response.status(Response.Status.CREATED).entity(ApiResponse.build(objList)).build();
    //
    /*/
    return Response.status(Response.Status.OK).entity(new GenericEntity<List<Object>>(objList){}).type(MediaType.APPLICATION_JSON).build();
    /*/
    /*/
    List<Object> myList = new ArrayList<>();
    return Response.ok().entity(new GenericEntity<List<Object>>(myList){}).build();
    /*/
    //
    //return new ApiResponse();
    //return Response.status(201).entity("text").build();
    /*/
    try {
      return Response.status(Response.Status.CREATED).entity(new ObjectMapper().writeValueAsString(new ApiResponse())).build();
    } catch (JsonProcessingException e) {
      logger.error("Exception", e);  
    }
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    /*/
    //return Response.status(Response.Status.CREATED).entity(new ApiResponse()).build();
  }
}
