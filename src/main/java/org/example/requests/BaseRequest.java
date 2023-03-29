package org.example.requests;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ClientException;
import org.example.EspApiException;
import org.example.Option;
import org.example.authentication.IAuthenticationProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Class for Base Request
 *
 * @param <T> - response class
 */
public abstract class BaseRequest<T> {

    private static final String TOKEN_HEADER = "Token";

    private final IAuthenticationProvider auth;
    private final List<Option> queryOptions;
    private final Class<? extends T> responseClass;
    private final HttpClient client;
    private final String requestUrl;


    /**
     * Base Request
     *
     * @param client        - http client
     * @param requestUrl    - requestUrl
     * @param authProvider  - authProvider authProvider
     * @param queryOptions  - query options
     * @param responseClass - response class
     */
    public BaseRequest(@NotNull final HttpClient client,
                       @NotNull final String requestUrl,
                       @NotNull final IAuthenticationProvider authProvider,
                       @Nullable List<Option> queryOptions,
                       @NotNull final Class<? extends T> responseClass
    ) {
        this.auth = authProvider;
        this.queryOptions = queryOptions;
        this.responseClass = responseClass;
        this.client = client;
        this.requestUrl = requestUrl;
    }

    /**
     * Builds the URL represented by the request
     * Combines the requestUrl and query options
     *
     * @return - URL
     * @throws MalformedURLException - the combined string does not constitute a valid URL
     */
    @NotNull
    public URL getRequestUrl() throws MalformedURLException {

        final var sb = new StringBuilder(requestUrl);

        if (queryOptions != null && queryOptions.size() > 0) {
            sb.append('?');

            for (var i = 0; i < queryOptions.size(); i++) {
                var name = queryOptions.get(i).getName();
                var value = queryOptions.get(i).getValue();

                if (value == null) {
                    continue;
                }

                sb.append(name)
                        .append('=')
                        .append(URLEncoder.encode(value.toString(), StandardCharsets.UTF_8).replace("\\+", "%20"));

                if (i < queryOptions.size() - 1) {
                    sb.append('&');
                }
            }
        }

        return new URL(sb.toString());
    }

    /**
     * Makes a GET request to the URL represented by the request
     *
     * @return - instance of the response type
     */
    @NotNull
    protected T send() {
        var resp = sendInternal();
        var statusCode = resp.statusCode();
        if (statusCode < 200 || statusCode > 299) {
            throw new EspApiException(statusCode, resp.body());
        }

        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        Annotation rootAnnotation = responseClass.getAnnotation(JsonRootName.class);
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, rootAnnotation != null);


        try {
            return mapper.readValue(resp.body(), responseClass);
        } catch (JsonProcessingException e) {
            throw new ClientException("Serialization error", e);
        }

    }


    /**
     * Makes a GET request and returns the response to the caller.
     * The response is mapped to a string and should be deserialized by the caller.
     *
     * @return - HttpResponse<String>
     */
    @NotNull
    private HttpResponse<String> sendInternal() {
        try {
            var req = HttpRequest.newBuilder()
                    .uri(getRequestUrl().toURI())
                    .header(TOKEN_HEADER, auth.getAuthorizationToken().get())
                    .GET()
                    .build();

            return client.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (final URISyntaxException ex) {
            throw new ClientException("Invalid URI", ex);
        } catch (final Exception ex) {
            throw new ClientException("Error executing request", ex);
        }
    }

}
