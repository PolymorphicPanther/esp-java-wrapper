package org.example;

public class ClientException extends RuntimeException {

    public ClientException(final String message, final Throwable ex){
        super(message, ex);
    }
}
