package org.example.requests;

import org.example.Option;
import org.example.authentication.IAuthenticationProvider;

import java.net.http.HttpClient;
import java.util.ArrayList;

public class AreaSearchRequestBuilder extends BaseRequestBuilder{

    private final String text;

    public AreaSearchRequestBuilder(final HttpClient client, final String requestUrl, final IAuthenticationProvider authProvider, final String text) {
        super(client, requestUrl, authProvider);
        this.text = text;
    }

    public AreaSearchRequestBuilder Text(String text){
        return new AreaSearchRequestBuilder(getClient(), getRequestUrl(), getAuth(), text);
    }

    public AreaSearchRequest build(){
        var options = new ArrayList<Option>(1);
        options.add(new Option("text", text));
        return new AreaSearchRequest(getClient(), getRequestUrl(), getAuth(), options);
    }
}
