package com.example.demo;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProblemDetailErrorHandlingControllerAdvice {

    @ExceptionHandler
    public ProblemDetail onException(IllegalArgumentException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), exception.getMessage());
    }
}
