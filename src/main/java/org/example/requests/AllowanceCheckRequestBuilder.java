package org.example.requests;

import org.example.authentication.IAuthenticationProvider;

import java.net.http.HttpClient;

public class AllowanceCheckRequestBuilder extends BaseRequestBuilder{
    public AllowanceCheckRequestBuilder(HttpClient client, String requestUrl, IAuthenticationProvider auth) {
        super(client, requestUrl, auth);
    }

    public AllowanceCheckRequest build(){
        var urlPath = "api_allowance";
        return new AllowanceCheckRequest(getClient(), addPathToUrl(urlPath), getAuth());
    }
}
