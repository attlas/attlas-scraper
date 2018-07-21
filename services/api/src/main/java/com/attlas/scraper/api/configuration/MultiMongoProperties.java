package com.attlas.scraper.api.configuration;

import com.attlas.scraper.api.ApplicationParameter;
import com.attlas.scraper.api.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

//@ConfigurationProperties
@Configuration
public class MultiMongoProperties {

  private MongoProperties primary = new MongoProperties();
/*
  public MultiMongoProperties() {}

  public MultiMongoProperties(MongoProperties primary) {
    this.primary = primary;
  }*/
  public MultiMongoProperties() {
    this.primary.setHost(Context.getInstance().asString(ApplicationParameter.MONGO_HOST));
    this.primary.setPort(Context.getInstance().asInt(ApplicationParameter.MONGO_PORT));
    this.primary.setDatabase(Context.getInstance().asString(ApplicationParameter.MONGO_DB));
  }

  public MongoProperties getPrimary() {
    return primary;
  }

  public void setPrimary(MongoProperties primary) {
    this.primary = primary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MultiMongoProperties that = (MultiMongoProperties) o;
    return Objects.equals(primary, that.primary);
  }

  @Override
  public int hashCode() {

    return Objects.hash(primary);
  }

  @Override
  public String toString() {
    return "MultiMongoProperties{" +
            "primary=" + primary +
            '}';
  }
}
