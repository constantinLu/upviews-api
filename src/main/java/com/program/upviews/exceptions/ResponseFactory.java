package com.program.upviews.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
    /**
     * @param ex         generic type of create
     * @param httpStatus status code for 400 and 500 series
     * @return responseEntity populated
     */
    ResponseEntity<Object> create(Exception ex, HttpStatus httpStatus) {
        return new ResponseEntity<>(new ExceptionModel(ex.getMessage(), httpStatus, LocalDateTime.now()), httpStatus);
    }
}
