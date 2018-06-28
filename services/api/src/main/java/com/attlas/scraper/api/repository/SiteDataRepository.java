package com.attlas.scraper.api.repository;

import com.attlas.scraper.api.model.SiteData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SiteDataRepository extends MongoRepository<SiteData, String> {

  public Optional<SiteData> findById(String siteDataId);
}
