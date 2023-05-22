package io.github.polymorphicpanther.jesp.authentication;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * Class for Basic Token Credential Auth Provider
 */
public class BasicTokenCredentialAuthProvider implements IAuthenticationProvider{

    private final String authToken;

    /**
     * BasicTokenCredentialAuthProvider
     *
     * @param authToken - auth token to authenticate requests
     */
    public BasicTokenCredentialAuthProvider(final String authToken) {
        this.authToken = authToken;
    }

    /**
     * Returns the auth token as a string
     * @return future containing auth token
     */
    @Override
    @NotNull
    public CompletableFuture<String> getAuthorizationToken() {
        return CompletableFuture.completedFuture(authToken);
    }
}
