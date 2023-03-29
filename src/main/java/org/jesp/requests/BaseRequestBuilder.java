package org.jesp.requests;

import org.jesp.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.Objects;

/**
 * Class for Base Request Builder
 */
public class BaseRequestBuilder {
    private final HttpClient client;
    private final String requestUrl;
    private final IAuthenticationProvider authProvider;

    /**
     * Base Request Builder
     *
     * @param client     - http client
     * @param requestUrl - request URL
     * @param auth       - auth provider
     */
    public BaseRequestBuilder(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth) {
        this.client = Objects.requireNonNull(client, "parameter client cannot be null");
        this.requestUrl = Objects.requireNonNull(requestUrl, "parameter requestUrl cannot be null");
        this.authProvider = Objects.requireNonNull(auth, "parameter auth provider cannot be null");
    }

    /**
     * Gets the client
     *
     * @return - http client
     */
    @NotNull
    protected HttpClient getClient() {
        return client;
    }

    /**
     * Gets the request URL
     *
     * @return - request URL
     */
    @NotNull
    protected String getRequestUrl() {
        return requestUrl;
    }

    /**
     * Gets the authentication provider
     *
     * @return - auth provider
     */
    @NotNull
    protected IAuthenticationProvider getAuthProvider() {
        return authProvider;
    }

    /**
     * Returns the request URL with an extra segment added to it
     *
     * @param segment - path to add
     * @return - url with segment appended
     */
    @NotNull
    protected String addSegmentToUrl(@NotNull final String segment) {
        Objects.requireNonNull(segment, "segment cannot be null");
        if (requestUrl.endsWith("/")) {
            return requestUrl + segment;
        }
        return requestUrl + '/' + segment;
    }
}
