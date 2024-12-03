package com.anjotics.anjotics.exceptions;

/**
 * Custom exception thrown when an uploaded CSV file is empty.
 */
public class EmptyCsvException extends RuntimeException {
    public EmptyCsvException(String message) {
        super(message);
    }
}