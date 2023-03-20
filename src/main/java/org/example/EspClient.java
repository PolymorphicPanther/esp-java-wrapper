package org.example;

import org.example.authentication.IAuthenticationProvider;
import org.example.requests.AllowanceRequestBuilder;
import org.example.requests.AreaRequestBuilder;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.Objects;

public class EspClient {

    public static final String DEFAULT_ESP_URL = "https://developer.sepush.co.za/business/2.0";
    private final IAuthenticationProvider auth;
    private final String baseUrl;

    private final HttpClient httpClient;


    private EspClient(final IAuthenticationProvider auth, final String baseUrl) {
        this.auth = auth;
        this.baseUrl = Objects.requireNonNullElse(baseUrl, DEFAULT_ESP_URL);

        httpClient = HttpClient.newHttpClient();
    }

    public AreaRequestBuilder area() {
        return new AreaRequestBuilder(httpClient, baseUrl, auth);
    }

    public AllowanceRequestBuilder allowance(){
        return new AllowanceRequestBuilder(httpClient, baseUrl, auth);
    }


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
         * @return Esp client object
         */
        @NotNull
        public EspClient build() {
            return new EspClient(auth, baseUrl);
        }
    }
}

