package org.example.requests;

import org.example.Option;
import org.example.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.ArrayList;

public class AreasNearByRequestBuilder {
    private final HttpClient client;
    private final String requestUrl;
    private final IAuthenticationProvider authProvider;
    private final double lat;
    private final double lon;

    public AreasNearByRequestBuilder(final HttpClient client, final String requestUrl, final IAuthenticationProvider auth,final double lat,final double lon) {
        this.client = client;
        this.requestUrl = requestUrl;
        this.authProvider = auth;
        this.lat = lat;
        this.lon = lon;
    }

    @NotNull
    public AreasNearByRequestBuilder lat(final double lat){
        return new AreasNearByRequestBuilder(client, requestUrl, authProvider, lat, lon);
    }

    @NotNull
    public AreasNearByRequestBuilder lon(final double lon){
        return new AreasNearByRequestBuilder(client, requestUrl, authProvider, lat, lon);
    }

    @NotNull
    public AreasNearByRequest build(){
        var options = new ArrayList<Option>(2);
        options.add(new Option("lat", lat));
        options.add(new Option("lon", lon));

        return new AreasNearByRequest(client, requestUrl, authProvider, options);
    }

}
