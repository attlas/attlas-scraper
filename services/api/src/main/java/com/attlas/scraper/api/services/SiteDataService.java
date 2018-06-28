package com.attlas.scraper.api.services;

import com.attlas.scraper.api.model.SiteData;

import java.util.List;

public interface SiteDataService {

  String testError();

  List<SiteData> getAllSiteData();

  SiteData getSiteDataById(String id);

  Boolean isSiteDataExist(SiteData siteData);

  String addSiteData(SiteData siteData);

  void updateSiteData(String id, SiteData siteData);
}
