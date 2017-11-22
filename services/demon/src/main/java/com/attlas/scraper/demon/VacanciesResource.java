package com.attlas.scraper.demon;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 */
@Path("/docs/vacancies")
public class VacanciesResource {

  private static final Logger logger = Logger.getLogger(VacanciesResource.class);

  class ApiResponse {
    public int code = 0;
    public String message = "message";
    public ArrayList<Object> data = new ArrayList<>();
    public ApiResponse() {
      this.data.add("Random String");
      this.data.add(121); //int
      this.data.add(1.22); //double
      this.data.add(false); //bolean
    }
  }
  /**
   */
  @GET
  @Path("/{companies}/{dates}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacanciesByCompaniesAndDates(@Context UriInfo uriInfo, @PathParam("companies") String companies, @PathParam("dates") String dates) {
    logger.info(uriInfo.getRequestUri() + companies + dates);
    /*/
    List<Object> objList = new ArrayList<>();
    objList.add("Random String");
    objList.add(121); //int
    objList.add(1.22); //double
    objList.add(false); //boolean
    return Response.status(Response.Status.CREATED).entity(objList).build();
    /*/
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
    return Response.status(Response.Status.CREATED).entity(new ApiResponse()).build();
  }
}