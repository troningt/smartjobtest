package com.worshipplanner.mssecurity.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String errorMessage) {
        super(errorMessage + " not found");
    }
}
