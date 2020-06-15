package com.program.upviews.exceptions;

import com.program.upviews.exceptions.custom.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    private final ResponseFactory response;

    public ExceptionControllerAdvice(ResponseFactory response) {
        this.response = response;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFoundException(final UserNotFoundException e) {
        log.error(e.getMessage());
        return response.create(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity handleInvalidPasswordException(final InvalidPasswordException e) {
        log.error(e.getMessage());
        return response.create(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordMisMatchException.class)
    public ResponseEntity handlePasswordMisMatchException(final PasswordMisMatchException e) {
        log.error(e.getMessage());
        return response.create(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(final Exception e) {
        log.error(e.getMessage());
        return response.create(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity handleException(final AuthException e) {
        log.error(e.getMessage());
        return response.create(e, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InputStreamException.class)
    public ResponseEntity handleException(final InputStreamException e) {
        log.error(e.getMessage());
        return response.create(e, HttpStatus.NOT_FOUND);
    }
}