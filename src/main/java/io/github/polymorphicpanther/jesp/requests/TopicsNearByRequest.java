package io.github.polymorphicpanther.jesp.requests;

import io.github.polymorphicpanther.jesp.Option;
import io.github.polymorphicpanther.jesp.authentication.IAuthenticationProvider;
import io.github.polymorphicpanther.jesp.models.TopicsNearByResponse;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.util.List;

/**
 * Class for Topics Near By Request
 */
public class TopicsNearByRequest extends BaseRequest<TopicsNearByResponse> {
    /**
     * Request for Topics Near By
     *
     * @param client       - http client
     * @param requestUrl   - requestUrl
     * @param auth         - auth provider
     * @param queryOptions - query options
     */
    public TopicsNearByRequest(@NotNull final HttpClient client, @NotNull final String requestUrl, @NotNull final IAuthenticationProvider auth, @NotNull final List<Option> queryOptions) {
        super(client, requestUrl, auth, queryOptions, TopicsNearByResponse.class);
    }

    /**
     * Fetches topics near by from ESP
     *
     * @return - TopicsNearByResponse
     */
    @NotNull
    public TopicsNearByResponse get() {
        return send();
    }
}
