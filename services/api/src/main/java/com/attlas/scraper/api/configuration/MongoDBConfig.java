package com.attlas.scraper.api.configuration;

import com.attlas.scraper.api.model.SiteData;
import com.attlas.scraper.api.model.VacancyData;
import com.attlas.scraper.api.repository.SiteDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Date;

@EnableMongoRepositories(basePackages = "com.attlas.scraper.api.repository"
        , mongoTemplateRef = "primaryMongoTemplate")
@Configuration
public class MongoDBConfig {

}
