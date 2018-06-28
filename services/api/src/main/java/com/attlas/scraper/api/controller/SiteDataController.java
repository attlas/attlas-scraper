package com.attlas.scraper.api.controller;

import com.attlas.scraper.api.model.SiteData;
import com.attlas.scraper.api.services.SiteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/sitedata")
public class SiteDataController {

  @Autowired
  private SiteDataService siteDataService;

  @GetMapping
  @CrossOrigin("http://localhost:9000")
  public ResponseEntity<List<SiteData>> getAllSiteData() {
    List<SiteData> siteData = siteDataService.getAllSiteData();
    if (siteData.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok().body(siteData);
    }
  }
}
