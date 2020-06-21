package com.weather.config;

import static com.weather.client.Constants.WEATHER_PROVIDER_NAME_KEY;
import static com.weather.client.Constants.WEATHER_PROVIDER_OPEN_WEATHER_MAP;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("com.weather.openweathermap")
@ConditionalOnProperty(name = WEATHER_PROVIDER_NAME_KEY,
    havingValue = WEATHER_PROVIDER_OPEN_WEATHER_MAP, matchIfMissing = true)
public class OpenWeatherMapConfig {

    @NotBlank
    @URL
    private String url;

    @NotBlank
    private String apiKey;
}
