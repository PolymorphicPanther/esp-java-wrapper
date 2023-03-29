package org.example.requests;

import org.example.Option;
import org.example.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.ArrayList;

/**
 * Class for Area Search Request Builder
 */
public class AreaSearchRequestBuilder extends BaseRequestBuilder {

    private final String text;

    /**
     * Area Search Request Builder
     *
     * @param client       - http client
     * @param requestUrl   - requestUrl
     * @param authProvider - authProvider
     * @param text         - area descriptor e.g. fourways
     */
    public AreaSearchRequestBuilder(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider authProvider, @NotNull final String text) {
        super(client, requestUrl, authProvider);
        this.text = text;
    }

    /**
     * Create a new instance of AreaSearchRequestBuilder with given text
     *
     * @param text - text to search for e.g. fourways
     * @return - AreaSearchRequestBuilder
     */
    @NotNull
    public AreaSearchRequestBuilder Text(@NotNull String text) {
        return new AreaSearchRequestBuilder(getClient(), getRequestUrl(), getAuthProvider(), text);
    }

    /**
     * Creates the request
     *
     * @return - AreaSearchRequest
     */
    @NotNull
    public AreaSearchRequest build() {
        var options = new ArrayList<Option>(1);
        options.add(new Option("text", text));
        return new AreaSearchRequest(getClient(), getRequestUrl(), getAuthProvider(), options);
    }
}
