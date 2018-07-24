package com.attlas.scraper.api.configuration;

import com.mongodb.MongoClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.attlas.scraper.api.repository")
public class MongoDBConfig extends AbstractMongoConfiguration {

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

  @Override
  public MongoClient mongoClient() {
    return new MongoClient();
  }

  @Override
  protected String getDatabaseName() {
    return null;
  }
}
