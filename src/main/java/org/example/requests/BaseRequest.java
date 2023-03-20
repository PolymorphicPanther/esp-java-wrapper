package org.example.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ClientException;
import org.example.EspApiException;
import org.example.authentication.IAuthenticationProvider;
import org.example.Option;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class BaseRequest<T> {

    private static final String TOKEN_HEADER = "Token";

    private final IAuthenticationProvider auth;
    private final List<Option> queryOptions;
    private final Class<? extends T> responseClass;
    private final HttpClient client;
    private final String requestUrl;


    public BaseRequest(final HttpClient client,
                       final String requestUrl,
                       IAuthenticationProvider auth,
                       final List<Option> queryOptions,
                       final Class<? extends T> responseClass) {
        this.auth = auth;
        this.queryOptions = queryOptions;
        this.responseClass = responseClass;
        this.client = client;
        this.requestUrl = requestUrl;
    }

    public URL getRequestUrl() throws MalformedURLException {

        final var sb = new StringBuilder(requestUrl);

        if (queryOptions.size() > 0) {
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

    protected T send() throws ClientException {
        var resp = sendInternal();
        var statusCode = resp.statusCode();
        if (statusCode < 200 || statusCode > 299) {
            throw new EspApiException(statusCode, resp.body());
        }

        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            return mapper.readValue(resp.body(), responseClass);
        } catch (JsonProcessingException e) {
            throw new ClientException("Serialization error", e);
        }

    }

    protected HttpResponse<String> sendInternal() throws ClientException {
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
