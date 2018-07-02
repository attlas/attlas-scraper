package com.attlas.scraper.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "sites")
public class SiteData {

  @Id
  private String id;

  private String name;

  private String url;

  private Date timeStamp;

  @Indexed(direction = IndexDirection.ASCENDING)
  private List<VacancyData> vacanciesData;

  protected SiteData () {
    this.vacanciesData = new ArrayList<>();
  }

  public SiteData(String name, String url, Date timeStamp) {
    this.name = name;
    this.url = url;
    this.timeStamp = timeStamp;
  }

  public SiteData(String name, String url, Date timeStamp, List<VacancyData> vacanciesData) {
    this.name = name;
    this.url = url;
    this.timeStamp = timeStamp;
    this.vacanciesData = vacanciesData;
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

  public Date getTimeStamp() {
    return timeStamp;
  }

  public List<VacancyData> getVacanciesData() {
    return vacanciesData;
  }

}
