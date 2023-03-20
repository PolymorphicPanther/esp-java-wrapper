package org.example.requests;

import org.example.Option;
import org.example.authentication.IAuthenticationProvider;
import org.example.models.AreaSearchResponse;

import java.net.http.HttpClient;
import java.util.List;

public class AreaSearchRequest extends BaseRequest<AreaSearchResponse>{
    public AreaSearchRequest(HttpClient client, String requestUrl, IAuthenticationProvider auth, List<Option> queryOptions) {
        super(client, requestUrl, auth, queryOptions, AreaSearchResponse.class);
    }

    public AreaSearchResponse get(){
        return send();
    }
}
