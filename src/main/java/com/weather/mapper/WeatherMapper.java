package com.weather.mapper;

import com.weather.database.WeatherEntity;
import com.weather.model.WeatherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WeatherMapper {

    @Mapping(source = "name", target = "city")
    @Mapping(source = "sys.country", target = "country")
    @Mapping(source = "main.temp", target = "temperature")
    WeatherEntity toEntity(WeatherResponse response);
}
