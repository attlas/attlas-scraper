package com.attlas.scraper.api.services;

import com.attlas.scraper.api.model.SiteData;

import java.util.List;

public interface SiteDataService {

  List<SiteData> getListOfAllSite();

  String registerNewSite();

  SiteData getInfoAboutSite(String contactId);

  void updateInfoAboutSite(String contactId, SiteData siteData);

  void updateInfoAboutSiteOnInterrupt(String contactId, SiteData siteData);

  void deleteSite(String contactId);
}
