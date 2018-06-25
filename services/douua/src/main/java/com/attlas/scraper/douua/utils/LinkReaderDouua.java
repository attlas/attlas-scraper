package com.attlas.scraper.douua.utils;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public @Data class LinkReaderDouua {

  private static final Logger logger = LogManager.getLogger(LinkReaderDouua.class);

  public Set<String> createLinks(String path) {
    Set<String> douLink = null;
    try {
      douLink = Files.lines(Paths.get(path))
          /*.map(line -> line.split(" ", 1))*/
          .collect(Collectors.toSet());
    } catch (IOException e) {
      logger.error(e);
    }
    return douLink;
  }
}
