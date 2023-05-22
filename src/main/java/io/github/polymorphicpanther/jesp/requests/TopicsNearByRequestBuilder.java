package io.github.polymorphicpanther.jesp.requests;

import io.github.polymorphicpanther.jesp.Option;
import io.github.polymorphicpanther.jesp.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.ArrayList;

/**
 * Class for Topics Near By Request Builder
 */
public class TopicsNearByRequestBuilder extends BaseRequestBuilder {
    private final double lat;
    private final double lon;

    /**
     * Builder for TopicsNearByRequest
     *
     * @param client     - http client
     * @param requestUrl - requestUrl
     * @param auth       - auth provider
     * @param lat        - latitude coordinate
     * @param lon        - longitude coordinate
     */
    public TopicsNearByRequestBuilder(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth, final double lat, final double lon) {
        super(client, requestUrl, auth);
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Creates a new request with the given latitude coordinate
     *
     * @param lat - latitude coordinate
     * @return - TopicsNearByRequestBuilder
     */
    @NotNull
    public TopicsNearByRequestBuilder lat(final double lat) {
        return new TopicsNearByRequestBuilder(getClient(), getRequestUrl(), getAuthProvider(), lat, lon);
    }

    /**
     * Creates a new request with the given longitude coordinate
     *
     * @param lon - latitude coordinate
     * @return - TopicsNearByRequestBuilder
     */
    @NotNull
    public TopicsNearByRequestBuilder lon(final double lon) {
        return new TopicsNearByRequestBuilder(getClient(), getRequestUrl(), getAuthProvider(), lat, lon);
    }

    /**
     * Created the request
     *
     * @return - TopicsNearByRequest
     */
    @NotNull
    public TopicsNearByRequest build() {
        var urlPath = "topics_nearby";
        var options = new ArrayList<Option>(2);
        options.add(new Option("lat", lat));
        options.add(new Option("lon", lon));

        return new TopicsNearByRequest(getClient(), addSegmentToUrl(urlPath), getAuthProvider(), options);
    }
}
