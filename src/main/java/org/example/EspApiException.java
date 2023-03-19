package org.example;

public class EspApiException extends RuntimeException {
    public EspApiException(int errorCode, String message) {

        super(errorCode + ": " + message);
    }
}
