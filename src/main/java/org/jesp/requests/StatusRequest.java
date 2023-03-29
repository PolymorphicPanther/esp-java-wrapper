package org.jesp.requests;

import org.jesp.authentication.IAuthenticationProvider;
import org.jesp.models.StatusResponse;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;

/**
 * Class for Status Request
 */
public class StatusRequest extends BaseRequest<StatusResponse> {
    /**
     * Request for Status
     *
     * @param client       - http client
     * @param requestUrl   - request URL
     * @param authProvider - auth provider
     */
    public StatusRequest(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider authProvider) {
        super(client, requestUrl, authProvider, null, StatusResponse.class);
    }

    /**
     * Fetches the StatusResponse from ESP
     *
     * @return - StatusResponse
     */
    @NotNull
    public StatusResponse get() {
        return send();
    }
}
