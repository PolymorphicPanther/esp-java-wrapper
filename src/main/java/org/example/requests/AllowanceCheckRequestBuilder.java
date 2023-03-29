package org.example.requests;

import org.example.authentication.IAuthenticationProvider;

import java.net.http.HttpClient;

/**
 * Class for Allowance Check Request Builder
 */
public class AllowanceCheckRequestBuilder extends BaseRequestBuilder {

    /**
     * Request builder for AllowanceCheck
     *
     * @param client     - http client
     * @param requestUrl - requestUrl
     * @param auth       - auth provider
     */
    public AllowanceCheckRequestBuilder(final HttpClient client, final String requestUrl, final IAuthenticationProvider auth) {
        super(client, requestUrl, auth);
    }

    /**
     * Creates the request
     *
     * @return AllowanceCheckRequest instance
     */
    public AllowanceCheckRequest build() {
        var urlPath = "api_allowance";
        return new AllowanceCheckRequest(getClient(), addSegmentToUrl(urlPath), getAuthProvider());
    }
}
