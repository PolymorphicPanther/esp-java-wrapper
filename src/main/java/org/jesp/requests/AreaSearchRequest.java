package org.jesp.requests;

import org.jesp.Option;
import org.jesp.authentication.IAuthenticationProvider;
import org.jesp.models.AreaSearchResponse;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.List;

/**
 * Class for area search request
 * <p>
 * Searches for an area based on text
 */
public class AreaSearchRequest extends BaseRequest<AreaSearchResponse> {

    /**
     * Request for Area Search
     *
     * @param client       - http client
     * @param requestUrl   - requestUrl
     * @param auth         - authProvider
     * @param queryOptions - request query options
     */
    public AreaSearchRequest(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth, @NotNull final List<Option> queryOptions) {
        super(client, requestUrl, auth, queryOptions, AreaSearchResponse.class);
    }

    /**
     * Gets the AreaSearchResponse from ESP
     *
     * @return - AreaSearchResponse
     */
    @NotNull
    public AreaSearchResponse get() {
        return send();
    }
}
