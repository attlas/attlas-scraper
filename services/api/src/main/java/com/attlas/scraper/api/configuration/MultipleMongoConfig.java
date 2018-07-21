package com.attlas.scraper.api.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@EnableConfigurationProperties(MultipleMongoConfig.class)
public class MultipleMongoConfig {

  private final MultiMongoProperties multiMongoProperties;

  public MultipleMongoConfig(MultiMongoProperties multiMongoProperties) {
    this.multiMongoProperties = multiMongoProperties;
  }

  @Primary
  @Bean(name = "primaryMongoTemplate")
  public MongoTemplate primaryMongoTemplate() throws Exception {
    return new MongoTemplate(primaryFactory(this.multiMongoProperties.getPrimary()));
  }

  @Primary
  @Bean
  public MongoDbFactory primaryFactory(final MongoProperties mongoProperties) throws Exception {
    return new SimpleMongoDbFactory(new MongoClient(mongoProperties.getHost(), mongoProperties.getPort()),
            mongoProperties.getDatabase());
  }
}
