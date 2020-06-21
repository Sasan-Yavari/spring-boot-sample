package com.weather.service;

import com.weather.client.WeatherClient;
import com.weather.database.WeatherEntity;
import com.weather.database.WeatherRepository;
import com.weather.mapper.WeatherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient client;
    private final WeatherRepository repository;
    private final WeatherMapper mapper;

    /**
     * Retrieves the weather information from the configured weather client and maps it to the WeatherEntity and
     * then saves it to the database.
     *
     * @param city name of the city.
     * @return WeatherEntity
     */
    public WeatherEntity getWeather(String city) {
        WeatherEntity entity = mapper.toEntity(client.getWeather(city));
        repository.save(entity);

        return entity;
    }
}
