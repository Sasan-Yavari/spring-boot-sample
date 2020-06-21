package com.weather.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.immutables.value.Value.Immutable;

@Immutable
@ImmutableStyle
@JsonDeserialize(builder = WeatherResponse.Builder.class)
public interface WeatherResponseInterface {

    Optional<Coord> getCoord();

    Optional<List<Weather>> getWeather();

    Optional<String> getBase();

    Main getMain();

    Optional<Integer> getVisibility();

    Optional<Wind> getWind();

    Optional<Clouds> getClouds();

    Optional<Integer> getDt();

    Sys getSys();

    Integer getId();

    String getName();

    Optional<Integer> getCod();

    @JsonIgnore
    @JsonAnyGetter
    @JsonAnySetter
    Map<String, Object> getAdditionalProperties();
}
