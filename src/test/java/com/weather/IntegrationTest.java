package com.weather;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.database.WeatherEntity;
import com.weather.database.WeatherRepository;
import com.weather.model.ErrorResponse;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles({"it"})
public class IntegrationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private WeatherRepository repository;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void simpleCallTest() throws Exception {
        String response = mvc.perform(get("/weather?city=Amsterdam"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        WeatherEntity weatherEntity = objectMapper.readValue(response, WeatherEntity.class);

        assertEquals("Amsterdam", weatherEntity.getCity());
        assertEquals("NL", weatherEntity.getCountry());
    }

    @Test
    public void invalidCityNameTest() throws Exception {
        String response = mvc.perform(get("/weather?city=invalid"))
            .andExpect(status().is4xxClientError())
            .andReturn()
            .getResponse()
            .getContentAsString();

        ErrorResponse errorResponse = objectMapper.readValue(response, ErrorResponse.class);

        assertEquals(HttpStatus.NOT_FOUND, errorResponse.getHttpStatus());
        assertEquals("City not found", errorResponse.getMessage());
    }

    @Test
    public void saveFunctionalityTest() throws Exception {
        mvc.perform(get("/weather?city=Amsterdam"))
            .andExpect(status().isOk());

        List<WeatherEntity> entities = repository.findAll();
        assertEquals(1, entities.size());
        assertEquals("Amsterdam", entities.get(0).getCity());
        assertEquals("NL", entities.get(0).getCountry());
    }
}
