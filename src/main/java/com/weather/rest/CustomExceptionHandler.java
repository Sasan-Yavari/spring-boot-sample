package com.weather.rest;

import com.weather.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    protected ResponseEntity<ErrorResponse> handleClientExceptions(HttpClientErrorException ex) {
        log.error(ex.getMessage(), ex);
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(ErrorResponse.of(
            httpStatus,
            ex.getClass().getName(),
            "Weather service error"), httpStatus);
    }

    @ExceptionHandler(NotFound.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundException(NotFound ex) {
        log.error(ex.getMessage(), ex);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(ErrorResponse.of(
            httpStatus,
            ex.getClass().getName(),
            "City not found"), httpStatus);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleExceptions(Exception ex) {
        log.error(ex.getMessage(), ex);
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(ErrorResponse.of(
            httpStatus,
            ex.getClass().getName(),
            "Unknown Exception"), httpStatus);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getBadRequest(ex);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getBadRequest(ex);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getBadRequest(ex);
    }

    private ResponseEntity<Object> getBadRequest(Exception ex) {
        log.error(ex.getMessage(), ex);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(ErrorResponse.of(
            httpStatus,
            ex.getClass().getName(),
            ex.getMessage()), httpStatus);
    }
}
