package com.attlas.scraper.demon;

import javax.ws.rs.core.Response.Status;
import java.util.List;

class ApiResponse {
  //
  private int status = 0;
  public int getStatus() { return this.status; }
  //
  private String message = "";
  public String getMessage() { return this.message; }
  //
  private List<Object> data = null;
  public List<Object> getData() { return this.data; }

  /**
   *
   */
  public ApiResponse() {
  }

  /**
   *
   */
  public static ApiResponse build() {
    return build(Status.OK, "");
  }
  /**
   *
   */
  public static ApiResponse build(final Status status) {
    ApiResponse response = new ApiResponse();
    response.status = status.getStatusCode();
    return response;
  }

  /**
   *
   */
  public static ApiResponse build(final Status status, final String message) {
    ApiResponse response = ApiResponse.build(status);
    response.message = message;
    return response;
  }

  /**
   *
   */
  public static ApiResponse build(final String message) {
    ApiResponse response = ApiResponse.build(Status.OK);
    response.message = message;
    return response;
  }

  /**
   *
   */
  public static ApiResponse build(final Status status, final String message, final List<Object> data) {
    ApiResponse response = build(status, message);
    response.data = data;
    return response;
  }

  /**
   *
   */
  public static ApiResponse build(final List<Object> data) {
    ApiResponse response = build(Status.OK, "");
    response.data = data;
    return response;
  }
}

