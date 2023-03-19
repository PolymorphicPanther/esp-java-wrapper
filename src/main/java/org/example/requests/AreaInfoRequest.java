package org.example.requests;

import org.example.authentication.IAuthenticationProvider;
import org.example.Option;
import org.example.models.AreaInfoResponse;

import java.net.http.HttpClient;
import java.util.List;

public class AreaInfoRequest extends BaseRequest<AreaInfoResponse> {
    public AreaInfoRequest(HttpClient client, String requestUrl, IAuthenticationProvider auth, List<Option> options) {
        super(client, requestUrl, auth, options, AreaInfoResponse.class);
    }

    public AreaInfoResponse get() {
        return send();
    }
}
