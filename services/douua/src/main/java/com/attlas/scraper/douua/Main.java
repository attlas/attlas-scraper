package com.attlas.scraper.douua;

import com.attlas.scraper.douua.utils.LinkReaderDouua;
import com.attlas.scraper.douua.utils.ScraperDouua;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Set;

public class Main {

  public static void main(String[] args) {

    ScraperDouua douua = new ScraperDouua();
    LinkReaderDouua linkReaderDouua = new LinkReaderDouua();
    Set<String> tempLinks = linkReaderDouua.createLinks("links/douLinks.data");

    tempLinks.forEach(link -> {
      Document documment = Jsoup.connect(link);
    });

  }
}
