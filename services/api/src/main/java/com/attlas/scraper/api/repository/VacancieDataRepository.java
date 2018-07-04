package com.attlas.scraper.api.repository;

import com.attlas.scraper.api.model.VacancyData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancieDataRepository extends MongoRepository<VacancyData, String> {
}
