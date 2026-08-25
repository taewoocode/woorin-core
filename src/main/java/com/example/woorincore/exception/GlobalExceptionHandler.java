package com.example.woorincore.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        log.warn("BusinessException: {}", e.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
            .status(e.getStatus().value())
            .message(e.getMessage())
            .build();

        return ResponseEntity.status(e.getStatus()).body(errorResponse);
    }
}
