package org.jesp.requests;

import org.jesp.Option;
import org.jesp.authentication.IAuthenticationProvider;
import org.jesp.models.AreaInfoResponse;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.List;

/**
 * Class for Area Info Request
 * <p>
 * Obtain the id from Area Find or Area Search and use with this request.
 * This single request has everything you need to monitor upcoming loadshedding events for the chosen suburb.
 */
public class AreaInfoRequest extends BaseRequest<AreaInfoResponse> {
    /**
     * Request for Area Info
     *
     * @param client     - http client
     * @param requestUrl - requestUrl
     * @param auth       - auth provider
     * @param options    - request options
     */
    public AreaInfoRequest(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth, final List<Option> options) {
        super(client, requestUrl, auth, options, AreaInfoResponse.class);
    }

    /**
     * Gets AreaInfoResponse from ESP
     *
     * @return - AreaInfoResponse
     */
    public AreaInfoResponse get() {
        return send();
    }
}
