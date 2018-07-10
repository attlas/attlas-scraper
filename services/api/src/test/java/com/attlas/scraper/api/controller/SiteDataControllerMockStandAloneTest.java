package com.attlas.scraper.api.controller;

import com.attlas.scraper.api.exception.SiteDataExceptionHandler;
import com.attlas.scraper.api.model.SiteData;
import com.attlas.scraper.api.repository.SiteDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
public class SiteDataControllerMockStandAloneTest {


  //need to test : https://thepracticaldeveloper.com/2017/07/31/guide-spring-boot-controller-tests/


    private MockMvc mvc;

    @Mock
    private SiteDataRepository siteDataRepositoryMock;

    @InjectMocks
    private SiteDataController siteDataControllerMock;

    // This object will be magically initialized by the initFields method below.
    private JacksonTester<SiteData> jsonSiteDataMock;

    /*@Before
    public void setup() {
      // We would need this line if we would not use MockitoJUnitRunner
      // MockitoAnnotations.initMocks(this);
      // Initializes the JacksonTester
      JacksonTester.initFields(this, new ObjectMapper());
      // MockMvc standalone approach
      mvc = MockMvcBuilders.standaloneSetup(siteDataControllerMock)
          .setControllerAdvice(new SiteDataExceptionHandler())
          .addFilters(new SiteDataFilter())
          .build();
    }

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
      // given
      given(siteDataRepositoryMock.findById("1"))
          .willReturn(new SiteData("Rob", "www.google.com", new Date(), fgg));

      // when
      MockHttpServletResponse response = mvc.perform(
          get("/superheroes/2")
              .accept(MediaType.APPLICATION_JSON))
          .andReturn().getResponse();

      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo(
          jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
      );
    }

    @Test
    public void canRetrieveByIdWhenDoesNotExist() throws Exception {
      // given
      given(superHeroRepository.getSuperHero(2))
          .willThrow(new NonExistingHeroException());

      // when
      MockHttpServletResponse response = mvc.perform(
          get("/superheroes/2")
              .accept(MediaType.APPLICATION_JSON))
          .andReturn().getResponse();

      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
      assertThat(response.getContentAsString()).isEmpty();
    }

    @Test
    public void canRetrieveByNameWhenExists() throws Exception {
      // given
      given(superHeroRepository.getSuperHero("RobotMan"))
          .willReturn(Optional.of(new SuperHero("Rob", "Mannon", "RobotMan")));

      // when
      MockHttpServletResponse response = mvc.perform(
          get("/superheroes/?name=RobotMan")
              .accept(MediaType.APPLICATION_JSON))
          .andReturn().getResponse();

      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo(
          jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
      );
    }

    @Test
    public void canRetrieveByNameWhenDoesNotExist() throws Exception {
      // given
      given(superHeroRepository.getSuperHero("RobotMan"))
          .willReturn(Optional.empty());

      // when
      MockHttpServletResponse response = mvc.perform(
          get("/superheroes/?name=RobotMan")
              .accept(MediaType.APPLICATION_JSON))
          .andReturn().getResponse();

      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo("null");
    }

    @Test
    public void canCreateANewSuperHero() throws Exception {
      // when
      MockHttpServletResponse response = mvc.perform(
          post("/superheroes/").contentType(MediaType.APPLICATION_JSON).content(
              jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
          )).andReturn().getResponse();

      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void headerIsPresent() throws Exception {
      // when
      MockHttpServletResponse response = mvc.perform(
          get("/superheroes/2")
              .accept(MediaType.APPLICATION_JSON))
          .andReturn().getResponse();

      // then
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getHeaders("X-SUPERHERO-APP")).containsOnly("super-header");
    }*/
}
