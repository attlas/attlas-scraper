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
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/contacts/{contactId}/streams")
public class VacancyDataController {

  @Autowired
  private VacancyDataService vacancyDataService;

  @GetMapping
  @CrossOrigin
  public List<VacancyData> getAllVacancyForSite(@PathVariable String contactId, String siteName) {
    return Optional.ofNullable(vacancyDataService.getAllVacancyForSite(siteName))
        .orElseThrow(() -> new RuntimeException("no such vacancies or connection to db"));
  }

  @PostMapping
  @CrossOrigin
  public String createNewVacancy(@PathVariable String contactId, VacancyData vacancyData) {
    return "vacancy created : temporary mock";
  }

  @PutMapping(path = "/{streamId}")
  @CrossOrigin
  public void updateInfoAboutVacancy(@PathVariable String contactId, @PathVariable String streamId, VacancyData vacancyData) {
    System.out.println("mock for update Vacancy");;
  }

  @PostMapping(path = "/{streamId}")
  @CrossOrigin
  public void updateInfoAboutVacancyOnInterrupt(@PathVariable String contactId, @PathVariable String streamId, VacancyData vacancyData) {
    System.out.println("mock for partial update Vacancy");
  }

  @DeleteMapping(path = "/{streamId}")
  @CrossOrigin
  public void deleteVacancy(@PathVariable String contactId, @PathVariable String streamId) {
    System.out.println("mock for deleting Vacancy");
  }

}
