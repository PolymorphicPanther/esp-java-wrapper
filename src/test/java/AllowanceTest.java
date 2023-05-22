import io.github.polymorphicpanther.jesp.EspClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class AllowanceTest {
    EspClient espClient = null;

    @BeforeEach
    public void setup() {
        var testBase = new TestBase();
        espClient = testBase.getEspClient();
    }

    @Test
    public void getAllowance() {
        var allowanceCheckResponse = espClient.allowance()
                .check()
                .build()
                .get();

        Assertions.assertNotNull(allowanceCheckResponse);
    }
}
