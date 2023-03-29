import org.example.EspClient;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class TestBase {

    private static final String DEFAULT_ESP_URL = "https://developer.sepush.co.za/business/2.0";
    private static final String DEFAULT_TOKEN = "YOUR_TOKEN_HERE";

    private final String apiUrl;
    private final String accessToken;

    private EspClient espClient;

    public TestBase(@NotNull final String apiUrl, @NotNull final String accessToken) {
        this.apiUrl = apiUrl;
        this.accessToken = accessToken;
    }

    public TestBase(@NotNull final String accessToken) {
        this(DEFAULT_ESP_URL, accessToken);
    }

    public TestBase() {
        this(DEFAULT_ESP_URL, DEFAULT_TOKEN);
    }

    public EspClient getEspClient() {
        if (espClient == null) {
            espClient = new EspClient.Builder()
                    .authenticationProvider(() -> CompletableFuture.completedFuture(accessToken))
                    .setEspUrl(apiUrl)
                    .build();
        }
        return espClient;
    }
}
