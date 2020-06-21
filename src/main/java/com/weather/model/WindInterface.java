package com.weather.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;
import java.util.Optional;
import org.immutables.value.Value.Immutable;

@Immutable
@ImmutableStyle
public interface WindInterface {

    Optional<Double> getSpeed();

    Optional<Integer> getDeg();

    @JsonIgnore
    @JsonAnyGetter
    @JsonAnySetter
    Map<String, Object> getAdditionalProperties();
}
