/*
package com.attlas.scraper.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SiteDataControllerIT {

  @LocalServerPort
  private int port;

  private URL url;

  @Autowired
  private TestRestTemplate restTemplate;

  @Before
  public void setUp() throws MalformedURLException {
    this.url = new URL("http://localhost:"+ port + "/api/v1/contacts");
  }

  @Test
  public void getListOfAllSites() {
    //ResponseEntity<String> responseEntity = restTemplate.getForEntity(url.toString(), String.class);
    //assertThat(responseEntity.getBody(), equalTo("no list of site is presented or bad connection to db"));
  }
}
*/
