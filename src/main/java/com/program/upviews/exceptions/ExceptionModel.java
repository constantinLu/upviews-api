package com.program.upviews.exceptions;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
public class ExceptionModel {

    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
}