package com.attlas.scraper.api.services;

import com.attlas.scraper.api.model.SiteData;
import com.attlas.scraper.api.repository.SiteDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteDataMongoDB implements SiteDataService{

  @Autowired
  private SiteDataRepository siteDataRepository;

  @Override
  public String testError() {
    throw new RuntimeException();
  }

  @Override
  public List<SiteData> getAllSiteData() {
    return null;
  }

  @Override
  public SiteData getSiteDataById(String id) {
    return null;
  }

  @Override
  public Boolean isSiteDataExist(SiteData siteData) {
    return null;
  }

  @Override
  public String addSiteData(SiteData siteData) {
    return null;
  }

  @Override
  public void updateSiteData(String id, SiteData siteData) {

  }
}
