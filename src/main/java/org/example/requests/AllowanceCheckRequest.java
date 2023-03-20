package org.example.requests;

import org.example.authentication.IAuthenticationProvider;
import org.example.models.AllowanceCheckResponse;

import java.net.http.HttpClient;
import java.util.ArrayList;

public class AllowanceCheckRequest extends BaseRequest<AllowanceCheckResponse>{
    public AllowanceCheckRequest(HttpClient client, String requestUrl, IAuthenticationProvider auth){
        super(client, requestUrl, auth, new ArrayList<>(), AllowanceCheckResponse.class);
    }

    public AllowanceCheckResponse get(){
        return send();
    }
}
