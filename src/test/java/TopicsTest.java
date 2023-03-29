import org.example.EspClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class TopicsTest {

    EspClient espClient = null;

    @BeforeEach
    public void setup() {
        var testBase = new TestBase();
        espClient = testBase.getEspClient();
    }

    @Test
    public void getTopicsNearBy() {
        var topicsNearBy = espClient.topics()
                .nearBy(-26.0269658, 28.0137339)
                .build()
                .get();

        Assertions.assertNotNull(topicsNearBy);
    }
}
