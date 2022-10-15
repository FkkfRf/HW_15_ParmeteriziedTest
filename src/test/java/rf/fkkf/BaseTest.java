package rf.fkkf;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://world-weather.ru";
        Configuration.browserSize = "1300x1800";
        Configuration.holdBrowserOpen = true;
    }
}
