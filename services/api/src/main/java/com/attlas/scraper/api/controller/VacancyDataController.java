package com.attlas.scraper.api.controller;

import com.attlas.scraper.api.model.VacancyData;
import com.attlas.scraper.api.services.VacancyDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/contacts/{contactId}/streams")
public class VacancyDataController {

  @Autowired
  private VacancyDataService vacancyDataService;

  @GetMapping
  @CrossOrigin("http://localhost:8080")
  public List<VacancyData> getAllVacancyForSite(@PathVariable String contactId, String siteName) {
    return null;
  }

  @PostMapping
  @CrossOrigin("http://localhost:8080")
  public String createNewVacancy(@PathVariable String contactId, VacancyData vacancyData) {
    return null;
  }

  @PutMapping(path = "/{streamId}")
  @CrossOrigin("http://localhost:8080")
  public void updateInfoAboutVacancy(@PathVariable String contactId, @PathVariable String streamId, VacancyData vacancyData) {

  }

  @PostMapping(path = "/{streamId}")
  @CrossOrigin("http://localhost:8080")
  public void updateInfoAboutVacancyOnInterrupt(@PathVariable String contactId, @PathVariable String streamId, VacancyData vacancyData) {

  }

  @DeleteMapping(path = "/{streamId}")
  @CrossOrigin("http://localhost:8080")
  public void deleteVacancy(@PathVariable String contactId, @PathVariable String streamId) {

  }

}
