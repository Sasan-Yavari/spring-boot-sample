package com.weather.rest;

import com.weather.database.WeatherEntity;
import com.weather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api
@RequiredArgsConstructor
@RestController("weather-rest-api")
@RequestMapping(path = "/")
public class WeatherController {

    private final WeatherService service;

    /**
     * Returns weather information.
     *
     * @param city name of the city.
     * @return WeatherEntity with the weather information.
     */
    @ApiOperation(value = "Returns the weather information for specified city")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherEntity weather(@RequestParam(name = "city") String city) {
        return service.getWeather(city);
    }
}
