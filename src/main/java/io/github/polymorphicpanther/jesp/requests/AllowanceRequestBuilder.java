package io.github.polymorphicpanther.jesp.requests;

import io.github.polymorphicpanther.jesp.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;

/**
 * Class for Allowance Request Builder
 */
public class AllowanceRequestBuilder extends BaseRequestBuilder {

    /**
     * Request builder for Allowances
     *
     * @param client     - http client
     * @param requestUrl - requestUrl
     * @param auth       - auth provider
     */
    public AllowanceRequestBuilder(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth) {
        super(client, requestUrl, auth);
    }

    /**
     * Gets a request builder for checking the API allowance
     *
     * @return the request builder
     */
    @NotNull
    public AllowanceCheckRequestBuilder check() {
        return new AllowanceCheckRequestBuilder(getClient(), getRequestUrl(), getAuthProvider());
    }

}
