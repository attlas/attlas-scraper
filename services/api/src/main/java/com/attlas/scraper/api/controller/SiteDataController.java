package com.attlas.scraper.api.controller;

import com.attlas.scraper.api.model.SiteData;
import com.attlas.scraper.api.services.SiteDataService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/contacts")
public class SiteDataController {

  @Autowired
  private SiteDataService siteDataService;

  @GetMapping
  @CrossOrigin
  public List<SiteData> getListOfAllSite() {
    return Optional.ofNullable(siteDataService.getListOfAllSite()).orElseThrow(() -> new RuntimeException("no list of site is presented or bad connection to db"));
  }

  @PostMapping
  @CrossOrigin
  public String registerNewSite() {
    return "new site registered";
  }

  @GetMapping(path = "/{contactId}")
  @CrossOrigin("http://localhost:8080")
  public SiteData getInfoAboutSite(@PathVariable String contactId) {
    return Optional.ofNullable(siteDataService.getInfoAboutSite(contactId)).orElseThrow(() -> new RuntimeException("no site found or no connection to db"));
  }

  @PutMapping(path = "/{contactId}")
  @CrossOrigin
  public void updateInfoAboutSite(@PathVariable String contactId, SiteData siteData) {
    System.out.println("temporary mock: update info for site");
  }

  @PatchMapping(path = "/{contactId}")
  @CrossOrigin
  public void updateInfoAboutSiteOnInterrupt(@PathVariable String contactId, SiteData siteData) {
    System.out.println("temporary mock: update partially info for site");
  }

  @DeleteMapping(path = "/{contactId}")
  public void deleteSite(@PathVariable String contactId) {
    System.out.println("temporary mock: site deleted");
  }

}
