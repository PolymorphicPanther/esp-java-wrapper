package org.example.authentication;

import java.util.concurrent.CompletableFuture;

public class BasicTokenCredentialAuthProvider implements IAuthenticationProvider{

    private final String authToken;

    public BasicTokenCredentialAuthProvider(final String authToken) {
        this.authToken = authToken;
    }

    @Override
    public CompletableFuture<String> getAuthorizationToken() {
        return CompletableFuture.completedFuture(authToken);
    }
}
