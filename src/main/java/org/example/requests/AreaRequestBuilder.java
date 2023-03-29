package org.example.requests;

import org.example.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;

/**
 * Class for Area Request Builder
 */
public class AreaRequestBuilder extends BaseRequestBuilder {

    /**
     * Request builder for area related requests
     *
     * @param client     - http client
     * @param requestUrl - requestURL
     * @param auth       - auth provider
     */
    public AreaRequestBuilder(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth) {
        super(client, requestUrl, auth);
    }

    /**
     * Creates a request builder for retrieving Area Info
     *
     * @param areaId - ESP areaId
     * @return - AreaInfoRequestBuilder
     */
    @NotNull
    public AreaInfoRequestBuilder info(@NotNull final String areaId) {
        var urlPath = "area";
        return new AreaInfoRequestBuilder(getClient(), addSegmentToUrl(urlPath), getAuthProvider(), areaId);
    }

    /**
     * Creates a request builder for finding areas nearby
     *
     * @param lat - latitude coordinate
     * @param lon - longitude coordinate
     * @return - AreasNearByRequestBuilder
     */
    @NotNull
    public AreasNearByRequestBuilder nearBy(final double lat, final double lon) {
        var urlPath = "areas_nearby";
        return new AreasNearByRequestBuilder(getClient(), addSegmentToUrl(urlPath), getAuthProvider(), lat, lon);
    }

    /**
     * Creates a request builder to find areas based on text search
     *
     * @param text - area descriptor e.g. fourways
     * @return - AreaSearchRequestBuilder
     */
    @NotNull
    public AreaSearchRequestBuilder search(@NotNull final String text) {
        var urlPath = "areas_search";
        return new AreaSearchRequestBuilder(getClient(), addSegmentToUrl(urlPath), getAuthProvider(), text);
    }
}
