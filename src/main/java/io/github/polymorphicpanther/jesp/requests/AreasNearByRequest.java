package io.github.polymorphicpanther.jesp.requests;

import io.github.polymorphicpanther.jesp.Option;
import io.github.polymorphicpanther.jesp.authentication.IAuthenticationProvider;
import io.github.polymorphicpanther.jesp.models.AreasNearByResponse;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.ArrayList;

/**
 * Class for Areas Near By Request
 */
public class AreasNearByRequest extends BaseRequest<AreasNearByResponse> {

    /**
     * Request for Areas Near By
     *
     * @param client       - http client
     * @param requestUrl   - requestUrl
     * @param authProvider - auth provider
     * @param options      - request options
     */
    public AreasNearByRequest(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider authProvider, @NotNull final ArrayList<Option> options) {
        super(client, requestUrl, authProvider, options, AreasNearByResponse.class);
    }

    /**
     * Gets AreaNearByResponse from ESP
     *
     * @return - AreaNearByResponse
     */
    @NotNull
    public AreasNearByResponse get() {
        return send();
    }
}
