package org.example.requests;

import org.example.Option;
import org.example.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.ArrayList;

/**
 * Class for Areas Near By Request Builder
 */
public class AreasNearByRequestBuilder extends BaseRequestBuilder {

    private final double lat;
    private final double lon;

    /**
     * Area Near By Request Builder
     *
     * @param client     - http client
     * @param requestUrl - requestUrl
     * @param auth       - auth provider
     * @param lat        - latitude coordinate
     * @param lon        - longitude coordinate
     */
    public AreasNearByRequestBuilder(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth, final double lat, final double lon) {
        super(client, requestUrl, auth);
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Creates a new instance of AreasNearByRequestBuilder with the given latitude coordinate
     *
     * @param lat - latitude coordinate
     * @return AreasNearByRequestBuilder
     */
    @NotNull
    public AreasNearByRequestBuilder lat(final double lat) {
        return new AreasNearByRequestBuilder(getClient(), getRequestUrl(), getAuthProvider(), lat, lon);
    }

    /**
     * Creates a new instance of AreasNearByRequestBuilder with the given longitude coordinate
     *
     * @param lon - longitude coordinate
     * @return AreasNearByRequestBuilder
     */
    @NotNull
    public AreasNearByRequestBuilder lon(final double lon) {
        return new AreasNearByRequestBuilder(getClient(), getRequestUrl(), getAuthProvider(), lat, lon);
    }

    /**
     * Creates the request
     *
     * @return - AreasNearByRequest
     */
    @NotNull
    public AreasNearByRequest build() {
        var options = new ArrayList<Option>(2);
        options.add(new Option("lat", lat));
        options.add(new Option("lon", lon));

        return new AreasNearByRequest(getClient(), getRequestUrl(), getAuthProvider(), options);
    }

}
