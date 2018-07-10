package com.attlas.scraper.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class VacancyData {

  @Id
  private String id;

  private String name;

  private String url;

  private String tags;

  private Date timeStamp;

  private String description;

  protected VacancyData () {

  }

  public VacancyData(String name, String url, String tags, Date timeStamp, String description) {
    this.name = name;
    this.url = url;
    this.tags = tags;
    this.timeStamp = timeStamp;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public String getTags() {
    return tags;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public String getDescription() {
    return description;
  }
}
