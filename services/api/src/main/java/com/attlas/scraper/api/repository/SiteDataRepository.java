package com.attlas.scraper.api.repository;

import com.attlas.scraper.api.model.SiteData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

//@NoRepositoryBean
@Repository
public interface SiteDataRepository extends MongoRepository<SiteData, String> {

}
