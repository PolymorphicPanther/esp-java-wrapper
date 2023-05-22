package io.github.polymorphicpanther.jesp.requests;

import io.github.polymorphicpanther.jesp.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;

/**
 * Class for TopicsRequestBuilder
 */
public class TopicsRequestBuilder extends BaseRequestBuilder {

    /**
     * TopicsRequestBuilder
     *
     * @param client     - http client
     * @param requestUrl - requestUrl
     * @param auth       - auth provider
     */
    public TopicsRequestBuilder(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth) {
        super(client, requestUrl, auth);
    }

    /**
     * Creates a new TopicsNeayByRequestBuilder using the given co-ordinates
     *
     * @param lat - latitude coordinate
     * @param lon - longitude coordinate
     * @return - TopicsNearByRequestBuilder
     */
    @NotNull
    public TopicsNearByRequestBuilder nearBy(final double lat, final double lon) {
        return new TopicsNearByRequestBuilder(getClient(), getRequestUrl(), getAuthProvider(), lat, lon);
    }
}
