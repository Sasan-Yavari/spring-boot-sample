package com.weather.client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

import com.weather.config.OpenWeatherMapConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class OpenWeatherMapClientTest {

    private OpenWeatherMapClient client;

    @Mock
    private OpenWeatherMapConfig config;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void init() {
        client = new OpenWeatherMapClient(config, restTemplate);
    }

    @Test(expected = HttpClientErrorException.class)
    public void getWeatherWithThirdPartyException() {
        when(restTemplate.getForEntity(any(), any(), anyMap()))
            .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

        client.getWeather("Amsterdam");
    }
}
