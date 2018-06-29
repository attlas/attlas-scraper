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
  public List<SiteData> getListOfAllSite() {
    return null;
  }

  @Override
  public String registerNewSite() {
    return null;
  }

  @Override
  public SiteData getInfoAboutSite(String siteId) {
    return null;
  }

  @Override
  public void updateInfoAboutSite(String contactId, SiteData siteData) {

  }

  @Override
  public void updateInfoAboutSiteOnInterrupt(String contactId, SiteData siteData) {

  }

  @Override
  public void deleteSite(String contactId) {

  }
}
