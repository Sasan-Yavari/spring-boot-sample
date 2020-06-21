package com.weather.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.immutables.value.Value.Style;

@JsonDeserialize
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
@Style(
    allParameters = true,
    forceJacksonPropertyNames = false,
    get = {"get*", "is*"},
    typeAbstract = {"Abstract*", "*Interface"},
    typeImmutable = "*",
    depluralize = true,
    redactedMask = "<redacted>"
)
public @interface ImmutableStyle {

}
