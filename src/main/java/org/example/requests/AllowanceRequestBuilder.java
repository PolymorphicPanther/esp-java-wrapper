package org.example.requests;

import org.example.authentication.IAuthenticationProvider;

import java.net.http.HttpClient;

public class AllowanceRequestBuilder extends BaseRequestBuilder {

    public AllowanceRequestBuilder(final HttpClient client, final String requestUrl, final IAuthenticationProvider auth) {
        super(client, requestUrl, auth);
    }

    public AllowanceCheckRequestBuilder check(){
        return new AllowanceCheckRequestBuilder(getClient(), getRequestUrl(), getAuth());
    }

}
