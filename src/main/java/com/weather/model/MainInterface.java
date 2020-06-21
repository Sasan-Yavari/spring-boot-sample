package com.weather.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;
import java.util.Optional;
import org.immutables.value.Value.Immutable;

@Immutable
@ImmutableStyle
public interface MainInterface {

    Double getTemp();

    Optional<Integer> getPressure();

    Optional<Integer> getHumidity();

    Optional<Double> getTempMin();

    Optional<Double> getTempMax();

    @JsonIgnore
    @JsonAnyGetter
    @JsonAnySetter
    Map<String, Object> getAdditionalProperties();
}
