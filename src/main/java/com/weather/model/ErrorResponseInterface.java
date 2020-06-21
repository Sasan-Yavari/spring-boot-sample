package com.weather.model;

import org.immutables.value.Value.Immutable;
import org.springframework.http.HttpStatus;

@Immutable
@ImmutableStyle
public interface ErrorResponseInterface {

    HttpStatus getHttpStatus();

    String getException();

    String getMessage();
}
