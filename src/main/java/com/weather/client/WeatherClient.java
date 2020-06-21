package com.weather.client;

import com.weather.model.WeatherResponse;

public interface WeatherClient {

    WeatherResponse getWeather(String city);
}
