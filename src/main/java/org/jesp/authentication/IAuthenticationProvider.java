package org.jesp.authentication;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * Provides authentication token for requests to the ESP API
 */
public interface IAuthenticationProvider {
    /**
     * Returns a token that can be used to authenticate requests
     * @return future with the token
     */

    @NotNull
    CompletableFuture<String> getAuthorizationToken();
}
