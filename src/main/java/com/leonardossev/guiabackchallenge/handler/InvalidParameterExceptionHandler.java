package com.leonardossev.guiabackchallenge.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.InvalidParameterException;

/**
 * Representa o tratamento que será feito quando @link{java.security.InvalidParameterException} for lançada. O código de
 * status da requisição, quando essa requisição for lançada, será 400, representando Bad Request.
 *
 * @author leonardossev
 * @author https://github.com/leonardossev
 * @version 25/12/2020
 */
@ControllerAdvice
public class InvalidParameterExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidParameterException.class})
    public ResponseEntity<Object> handleInvalidParameterException(final InvalidParameterException exception,
                                                                  final WebRequest request) {
        return new ResponseEntity<>(
            exception.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST
        );
    }
}
