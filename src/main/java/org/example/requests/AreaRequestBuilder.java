package org.example.requests;

import org.example.authentication.IAuthenticationProvider;

import java.net.http.HttpClient;

public class AreaRequestBuilder extends BaseRequestBuilder {

    public AreaRequestBuilder(final HttpClient client, final String requestUrl, IAuthenticationProvider auth) {
        super(client, requestUrl, auth);
    }

    public AreaInfoRequestBuilder info(String areaId) {
        var urlPath = "area";
        return new AreaInfoRequestBuilder(getClient(), addPathToUrl(urlPath), getAuth(), areaId);
    }

    public AreasNearByRequestBuilder nearBy(double lat, double lon){
        var urlPath = "areas_nearby";
        return new AreasNearByRequestBuilder(getClient(), addPathToUrl(urlPath), getAuth(), lat, lon);
    }

    public AreaSearchRequestBuilder search(String text){
        var urlPath = "areas_search";
        return new AreaSearchRequestBuilder(getClient(), addPathToUrl(urlPath), getAuth(), text);
    }
}
