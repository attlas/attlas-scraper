package com.attlas.scraper.api.services;

import com.attlas.scraper.api.model.VacancyData;

import java.util.List;

public interface VacancyDataService {

  List<VacancyData> getAllVacancyForSite(String siteName);

  String createNewVacancy(VacancyData vacancyData);

  void updateInfoAboutVacancy(String vacancyId, VacancyData vacancyData);

  void updateInfoAboutVacancyOnInterrupt(String vacancyId, VacancyData vacancyData);

  void deleteVacancy(String vacancyId);

}
