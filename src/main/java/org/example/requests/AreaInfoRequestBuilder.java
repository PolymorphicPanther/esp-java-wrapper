package org.example.requests;


import org.example.authentication.IAuthenticationProvider;
import org.example.Option;
import org.example.SampleInfoTest;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Objects;

public class AreaInfoRequestBuilder {

    private final HttpClient client;
    private final String requestUrl;
    private final IAuthenticationProvider auth;
    private final String areaId;
    private SampleInfoTest testMode = null;

    public AreaInfoRequestBuilder(final HttpClient client, final String requestUrl, IAuthenticationProvider auth, final String areaId) {
        this.client = client;
        this.requestUrl = requestUrl;
        this.auth = auth;
        this.areaId = areaId;
    }

    @NotNull
    public AreaInfoRequestBuilder areaId(@NotNull final String areaId) {
        Objects.requireNonNull(areaId, "parameter areaId cannot be null");
        return new AreaInfoRequestBuilder(client, requestUrl, auth, areaId);
    }

    @NotNull
    public AreaInfoRequestBuilder test(@NotNull final SampleInfoTest testMode) {
        Objects.requireNonNull(testMode, "parameter areaId cannot be null");
        this.testMode = testMode;
        return this;
    }

    @NotNull
    public AreaInfoRequest build() {

        var options = new ArrayList<Option>();
        options.add(new Option("id", areaId));

        if (testMode != null) {
            options.add(new Option("test", testMode.toString()));
        }

        return new AreaInfoRequest(client, requestUrl, auth, options);
    }

}
