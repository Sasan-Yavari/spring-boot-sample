package com.weather.client;

import static com.weather.client.Constants.WEATHER_PROVIDER_NAME_KEY;
import static com.weather.client.Constants.WEATHER_PROVIDER_OPEN_WEATHER_MAP;

import com.weather.config.OpenWeatherMapConfig;
import com.weather.model.WeatherResponse;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(name = WEATHER_PROVIDER_NAME_KEY,
    havingValue = WEATHER_PROVIDER_OPEN_WEATHER_MAP, matchIfMissing = true)
public class OpenWeatherMapClient implements WeatherClient {

    private final OpenWeatherMapConfig config;
    private final RestTemplate restTemplate;

    /**
     * Retrieves and returns the weather of the city from OpenWeatherMap service.
     *
     * @param city name of the city.
     * @return WeatherEntity that contains weather information.
     */
    @Override
    public WeatherResponse getWeather(String city) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("city", city);
        parameters.put("apikey", config.getApiKey());

        ResponseEntity<WeatherResponse> response = restTemplate
            .getForEntity(config.getUrl(), WeatherResponse.class, parameters);

        return response.getBody();
    }
}
