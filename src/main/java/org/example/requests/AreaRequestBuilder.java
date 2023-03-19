package org.example.requests;

import org.example.authentication.IAuthenticationProvider;

import java.net.http.HttpClient;

public class AreaRequestBuilder {

    private final HttpClient client;
    private final String requestUrl;
    private final IAuthenticationProvider auth;

    public AreaRequestBuilder(final HttpClient client, final String requestUrl, IAuthenticationProvider auth) {
        this.client = client;
        this.requestUrl = requestUrl;
        this.auth = auth;
    }

    public AreaInfoRequestBuilder info(String areaId) {
        var urlPath = "area";
        return new AreaInfoRequestBuilder(client, addPathToUrl(requestUrl, urlPath), auth, areaId);
    }

//    public AreasNearByRequestBuilder areasNearBy(){
//
//    }
//
//    public AreaSearchRequestBuilder areaSearch(){
//
//    }

    private String addPathToUrl(String url, String path) {
        if (url.endsWith("/")) {
            return url + path;
        }
        return url + '/' + path;
    }
}
