package org.example.requests;

import org.example.authentication.IAuthenticationProvider;

import java.net.http.HttpClient;

public class BaseRequestBuilder {
    private final HttpClient client;
    private final String requestUrl;
    private final IAuthenticationProvider auth;

    public BaseRequestBuilder(final HttpClient client, final String requestUrl, final IAuthenticationProvider auth) {
        this.client = client;
        this.requestUrl = requestUrl;
        this.auth = auth;
    }

    protected HttpClient getClient() {
        return client;
    }

    protected String getRequestUrl() {
        return requestUrl;
    }

    protected IAuthenticationProvider getAuth() {
        return auth;
    }

    protected String addPathToUrl(String path) {
        if (requestUrl.endsWith("/")) {
            return requestUrl + path;
        }
        return requestUrl + '/' + path;
    }
}
