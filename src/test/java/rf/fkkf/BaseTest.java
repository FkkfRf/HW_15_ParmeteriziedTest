package rf.fkkf;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://world-weather.ru";
        Configuration.browserSize = "1920x1986";
        Configuration.holdBrowserOpen = true;
    }
}
