package com.weather.mapper;

import static com.weather.DataProvider.CITY;
import static com.weather.DataProvider.COUNTRY;
import static com.weather.DataProvider.TEMPERATURE;
import static com.weather.DataProvider.getSimpleWeatherResponse;
import static org.junit.Assert.assertEquals;

import com.weather.database.WeatherEntity;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

public class WeatherMapperTest {

    private final WeatherMapper mapper = Mappers.getMapper(WeatherMapper.class);

    @Test
    public void toEntity() {
        WeatherEntity weatherEntity = mapper.toEntity(getSimpleWeatherResponse());

        assertEquals(COUNTRY, weatherEntity.getCountry());
        assertEquals(CITY, weatherEntity.getCity());
        assertEquals(TEMPERATURE, weatherEntity.getTemperature());
    }
}
