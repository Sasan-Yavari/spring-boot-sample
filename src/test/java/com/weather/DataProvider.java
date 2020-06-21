package com.weather;

import com.weather.model.Main;
import com.weather.model.Sys;
import com.weather.model.WeatherResponse;
import java.util.HashMap;
import java.util.Optional;

public class DataProvider {

    public static final String COUNTRY = "NL";
    public static final String CITY = "Amsterdam";
    public static final Double TEMPERATURE = 27.0;

    public static WeatherResponse getSimpleWeatherResponse() {
        return WeatherResponse.of(
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Main.of(TEMPERATURE, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                new HashMap<>()),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Sys.of(Optional.empty(), 1, Optional.empty(), COUNTRY, Optional.empty(), Optional.empty(), new HashMap<>()),
            1,
            CITY,
            Optional.empty(),
            new HashMap<>());
    }
}
