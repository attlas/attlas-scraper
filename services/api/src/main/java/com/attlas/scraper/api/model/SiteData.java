package com.attlas.scraper.api.model;

import org.springframework.data.annotation.Id;

public class SiteData {

  @Id
  private String id;
  private String tags;
  private String description;

  public SiteData() {
  }

  public SiteData(String tags, String description) {
    this.tags = tags;
    this.description = description;
  }


  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
