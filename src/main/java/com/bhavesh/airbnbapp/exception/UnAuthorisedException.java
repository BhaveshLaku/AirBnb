package com.bhavesh.airbnbapp.exception;


public class UnAuthorisedException extends RuntimeException {
    public UnAuthorisedException(String message) {
        super(message);
    }
}
