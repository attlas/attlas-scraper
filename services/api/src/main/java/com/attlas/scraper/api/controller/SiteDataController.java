package com.attlas.scraper.api.controller;

import com.attlas.scraper.api.model.SiteData;
import com.attlas.scraper.api.services.SiteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/contacts")
public class SiteDataController {

  @Autowired
  private SiteDataService siteDataService;

  @GetMapping
  @CrossOrigin("http://localhost:8080")
  public List<SiteData> getListOfAllSite() {
    return null;
  }

  @PostMapping
  @CrossOrigin("http://localhost:8080")
  public String registerNewSite() {
    return null;
  }

  @GetMapping(path = "/{contactId}")
  @CrossOrigin("http://localhost:8080")
  public SiteData getInfoAboutSite(@PathVariable String contactId) {
    return null;
  }

  @PutMapping(path = "/{contactId}")
  @CrossOrigin("http://localhost:8080")
  public void updateInfoAboutSite(@PathVariable String contactId, SiteData siteData) {

  }

  @PatchMapping(path = "/{contactId}")
  @CrossOrigin("http://localhost:8080")
  public void updateInfoAboutSiteOnInterrupt(@PathVariable String contactId, SiteData siteData) {

  }

  @DeleteMapping(path = "/{contactId}")
  public void deleteSite(@PathVariable String contactId) {

  }

}
