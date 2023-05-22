import io.github.polymorphicpanther.jesp.EspClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class AreasTest {
    EspClient espClient = null;

    @BeforeEach
    public void setup() {
        var testBase = new TestBase();
        espClient = testBase.getEspClient();
    }

    @Test
    public void getAreaNearBy() {
        var areaNearBy = espClient.areas()
                .nearBy(-26.0269658, 28.0137339)
                .build()
                .get();

        Assertions.assertNotNull(areaNearBy);
    }

    @Test
    public void getAreaInfo() {
        var areaInfo = espClient.areas().info("eskde-10-fourwaysext10cityofjohannesburggauteng")
                .build()
                .get();

        Assertions.assertNotNull(areaInfo);
    }

    @Test
    public void getAreaSearch() {
        var areaSearch = espClient.areas().search("kokstad")
                .build()
                .get();

        Assertions.assertNotNull(areaSearch);
    }
}
