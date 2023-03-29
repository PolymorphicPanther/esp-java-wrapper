package org.jesp.requests;

import org.jesp.authentication.IAuthenticationProvider;
import org.jesp.models.AllowanceCheckResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.http.HttpClient;
import java.util.ArrayList;

/**
 * Class for Allowance Check Request
 * Check allowance allocated for token
 * NOTE: This call doesn't count towards your quota.
 */
public class AllowanceCheckRequest extends BaseRequest<AllowanceCheckResponse> {
    /**
     * Request for Allowance Check
     *
     * @param client     - http client
     * @param requestUrl - requestUrl
     * @param auth       - auth provider
     */
    public AllowanceCheckRequest(
            @NotNull final HttpClient client,
            @NotNull final String requestUrl,
            @NotNull final IAuthenticationProvider auth
    ) {
        super(client, requestUrl, auth, new ArrayList<>(), AllowanceCheckResponse.class);
    }

    /**
     * Gets the AllowanceCheckResponse from ESP
     *
     * @return - AllowanceCheckResponse
     */
    @Nullable
    public AllowanceCheckResponse get() {
        return send();
    }
}
