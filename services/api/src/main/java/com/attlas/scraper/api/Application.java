package com.attlas.scraper.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
        org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration.class})
@EntityScan(basePackages = "com.attlas.scraper.api.model")
public class Application {

  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    logger.debug("--Application Started--");
  }
}

/*
stacktrace errors:
        MongoSocketOpenException coming from DefaultServerMonitor isn't something you can do anything about.
        Regarding MongoTimeoutException coming from DefaultIndexOperations: Creating a MongoTemplate initiates
        index creation.
        This fails if MongoDB is down. Remove either @Indexed from your document classes or exclude the
        initial entities by adjusting @EntityScan so indexes are created lazily.*/
