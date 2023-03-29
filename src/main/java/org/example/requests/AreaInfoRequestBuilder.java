package org.example.requests;


import org.example.Option;
import org.example.SampleInfo;
import org.example.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class for Area Info Request Builder
 */
public class AreaInfoRequestBuilder extends BaseRequestBuilder {

    private final String areaId;
    private SampleInfo testMode = null;

    /**
     * Request builder for Area Info
     *
     * @param client     - http client
     * @param requestUrl - requestUrl
     * @param auth       - auth provider
     * @param areaId     - ESP areaId
     */
    public AreaInfoRequestBuilder(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth, @NotNull final String areaId) {
        super(client, requestUrl, auth);
        this.areaId = areaId;
    }

    /**
     * Create a new AreaInfoRequestBuilder with the given areaId
     *
     * @param areaId - ESP areId
     * @return new instance of AreaInfoRequestBuilder
     */
    @NotNull
    public AreaInfoRequestBuilder areaId(@NotNull final String areaId) {
        Objects.requireNonNull(areaId, "parameter areaId cannot be null");
        return new AreaInfoRequestBuilder(getClient(), getRequestUrl(), getAuthProvider(), areaId);
    }

    /**
     * Indicates SAMPLE events data should be returned
     * SampleInfo.CURRENT will return a loadshedding event which is occurring right now
     * SampleInfo.FUTURE will return a loadshedding event starting on the next hour
     * Note: The schedule returned with testing data is NOT accurate data; but only for testing purposes.
     * The area name and source is updated to identify that this is testing data.
     * Note: a test request will not count towards your quota.
     *
     * @param testMode - type of test events to retrieve
     * @return - request builder
     */
    @NotNull
    public AreaInfoRequestBuilder test(@NotNull final SampleInfo testMode) {
        Objects.requireNonNull(testMode, "parameter areaId cannot be null");
        this.testMode = testMode;
        return this;
    }

    /**
     * Creates the request
     *
     * @return - AreasInfoRequest instance
     */
    @NotNull
    public AreaInfoRequest build() {

        var options = new ArrayList<Option>();
        options.add(new Option("id", areaId));

        if (testMode != null) {
            options.add(new Option("test", testMode.toString()));
        }

        return new AreaInfoRequest(getClient(), getRequestUrl(), getAuthProvider(), options);
    }

}
