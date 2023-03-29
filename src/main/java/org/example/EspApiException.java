package org.example;

import org.jetbrains.annotations.NotNull;

/**
 * Used to wrap non-200 responses from the ESP API
 */
public class EspApiException extends RuntimeException {
    /**
     * Create an EspApiException
     *
     * @param errorCode - response error code e.g. 404, 401 etc...
     * @param message   - response message
     */
    public EspApiException(int errorCode, @NotNull String message) {

        super(errorCode + ": " + message);
    }
}
