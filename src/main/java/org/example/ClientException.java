package org.example;

import org.jetbrains.annotations.NotNull;

/**
 * Exception from the library. This indicates the error occurred internally, i.e. possibly with serializing or some other
 * cause and is not necessarily due to a non 200 response from ESP.
 */
public class ClientException extends RuntimeException {

    /**
     * Create a Client exception with a message
     *
     * @param message - exception message
     * @param ex      - inner exception
     */
    public ClientException(@NotNull final String message, @NotNull final Throwable ex) {
        super(message, ex);
    }
}
