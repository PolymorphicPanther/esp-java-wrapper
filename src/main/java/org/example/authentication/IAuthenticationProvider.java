package org.example.authentication;

import java.util.concurrent.CompletableFuture;

public interface IAuthenticationProvider {
    CompletableFuture<String> getAuthorizationToken();
}
