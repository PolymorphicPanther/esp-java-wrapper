package org.example.requests;

import org.example.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;

/**
 * Class for Status Request Builder
 */
public class StatusRequestBuilder extends BaseRequestBuilder {

    /**
     * Status Request Builder
     *
     * @param httpClient   - http client
     * @param baseUrl      - base url
     * @param authProvider - auth provider
     */
    public StatusRequestBuilder(@NotNull final HttpClient httpClient, @NotNull final String baseUrl, @NotNull final IAuthenticationProvider authProvider) {
        super(httpClient, baseUrl, authProvider);
    }

    /**
     * Create the request
     *
     * @return - StatusRequest
     */
    @NotNull
    public StatusRequest build() {
        var urlPath = "status";
        return new StatusRequest(getClient(), addSegmentToUrl(urlPath), getAuthProvider());
    }
}
