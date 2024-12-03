package com.anjotics.anjotics.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler to manage exceptions across the whole applsication.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles EmptyCsvException and returns a custom response.
     *
     * @param ex the EmptyCsvException
     * @return ResponseEntity with custom error message and HTTP status 400
     */
    @ExceptionHandler(EmptyCsvException.class)
    public ResponseEntity<Map<String, Object>> handleEmptyCsvException(EmptyCsvException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());
        body.put("path", "/api/users/import");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles generic exceptions and returns a custom response.
     *
     * @param ex the Exception
     * @return ResponseEntity with custom error message and HTTP status 500
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", "An unexpected error occurred.");
        body.put("path", "/api/users/import");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}