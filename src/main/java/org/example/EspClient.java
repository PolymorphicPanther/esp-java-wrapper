package org.example;

import org.example.authentication.IAuthenticationProvider;
import org.example.requests.AllowanceRequestBuilder;
import org.example.requests.AreaRequestBuilder;
import org.example.requests.StatusRequestBuilder;
import org.example.requests.TopicsRequestBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.http.HttpClient;
import java.util.Objects;

/**
 * Class for Esp Client
 */
public class EspClient {

    public static final String DEFAULT_ESP_URL = "https://developer.sepush.co.za/business/2.0";
    private final IAuthenticationProvider auth;
    private final String baseUrl;

    private final HttpClient httpClient;


    /**
     * Restricted ESP client constructor
     *
     * @param authProvider - auth provider
     * @param baseUrl      - base URL
     */
    private EspClient(@NotNull final IAuthenticationProvider authProvider, @Nullable final String baseUrl) {
        this.auth = authProvider;
        this.baseUrl = Objects.requireNonNullElse(baseUrl, DEFAULT_ESP_URL);

        httpClient = HttpClient.newHttpClient();
    }

    /**
     * Creates a request builder for Area related requests
     *
     * @return AreaRequestBuilder
     */
    @NotNull
    public AreaRequestBuilder areas() {
        return new AreaRequestBuilder(httpClient, baseUrl, auth);
    }

    /**
     * Creates a request builder for Topic related requests
     *
     * @return TopicsRequestBuilder
     */
    @NotNull
    public TopicsRequestBuilder topics() {
        return new TopicsRequestBuilder(httpClient, baseUrl, auth);
    }

    /**
     * Creates a request builder for Allowance related requests
     *
     * @return AllowanceRequestBuilder
     */
    @NotNull
    public AllowanceRequestBuilder allowance() {
        return new AllowanceRequestBuilder(httpClient, baseUrl, auth);
    }

    /**
     * Created a request builder for Status related requests
     *
     * @return StatusRequestBuilder
     */
    @NotNull
    public StatusRequestBuilder status() {
        return new StatusRequestBuilder(httpClient, baseUrl, auth);
    }


    /**
     * Builder class for EspClient
     */
    public static class Builder {
        private IAuthenticationProvider auth;
        private String baseUrl;

        /**
         * Sets the authentication provider
         *
         * @param auth - the authentication provider
         * @return instance of this builder
         */
        @NotNull
        public Builder authenticationProvider(@NotNull final IAuthenticationProvider auth) {
            Objects.requireNonNull(auth, "parameter auth cannot be null");
            this.auth = auth;
            return this;
        }

        /**
         * Sets the baseUrl
         *
         * @param baseUrl - baseUrl
         * @return instance of this builder
         */
        @NotNull
        public Builder setEspUrl(@NotNull final String baseUrl) {
            Objects.requireNonNull(auth, "parameter baseUrl cannot be null");
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * Builds & returns the EspClient
         *
         * @return Esp client object
         */
        @NotNull
        public EspClient build() {
            return new EspClient(auth, baseUrl);
        }
    }
}

