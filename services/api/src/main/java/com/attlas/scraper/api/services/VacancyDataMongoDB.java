package com.attlas.scraper.api.services;

import com.attlas.scraper.api.model.VacancyData;
import com.attlas.scraper.api.repository.VacancieDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyDataMongoDB implements VacancyDataService {

//  @Autowired
//  private VacancieDataRepository vacancieDataRepository;

  @Override
  public List<VacancyData> getAllVacancyForSite(String siteName) {
    return null;
  }

  @Override
  public String createNewVacancy(VacancyData vacancyData) {
    return null;
  }

  @Override
  public void updateInfoAboutVacancy(String vacancyId, VacancyData vacancyData) {

  }

  @Override
  public void updateInfoAboutVacancyOnInterrupt(String vacancyId, VacancyData vacancyData) {

  }

  @Override
  public void deleteVacancy(String vacancyId) {

  }
}
