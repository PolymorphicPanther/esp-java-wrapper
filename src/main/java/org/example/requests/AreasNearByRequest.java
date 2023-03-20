package org.example.requests;

import org.example.Option;
import org.example.authentication.IAuthenticationProvider;
import org.example.models.AreasNearByResponse;

import java.net.http.HttpClient;
import java.util.ArrayList;

public class AreasNearByRequest extends BaseRequest<AreasNearByResponse> {
    public AreasNearByRequest(HttpClient client, String requestUrl, IAuthenticationProvider authProvider, ArrayList<Option> options) {
        super(client, requestUrl, authProvider, options, AreasNearByResponse.class);
    }

    public AreasNearByResponse get() {
        return send();
    }
}
