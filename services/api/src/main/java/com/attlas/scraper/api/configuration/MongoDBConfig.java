package com.attlas.scraper.api.configuration;

import com.attlas.scraper.api.model.SiteData;
import com.attlas.scraper.api.model.VacancyData;
import com.attlas.scraper.api.repository.SiteDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Date;

//@EnableMongoRepositories(basePackageClasses = SiteDataRepository.class)
@Configuration
public class MongoDBConfig {

  @Bean
  CommandLineRunner commandLineRunner(/*SiteDataRepository siteDataRepository*/) {
    return args -> {
      //drop all siteData
      //siteDataRepository.deleteAll();

      //add some site into db
      /*/
      siteDataRepository.save(new SiteData("someSite1", "http://google.com", new Date()));
      siteDataRepository.save(new SiteData("someSite2", "http://google.com", new Date(),
          Arrays.asList(new VacancyData("fullstack", "http://google.com/search?q=fullstack", "full stack",
              new Date(), "Architector in full stack position"))));
      /*/
    };
  }
}
