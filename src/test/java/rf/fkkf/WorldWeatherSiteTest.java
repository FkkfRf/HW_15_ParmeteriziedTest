package rf.fkkf;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WorldWeatherSiteTest extends BaseTest{


    @ValueSource(strings = {"Санкт-Петербург", "Пермь", "Южно-Сахалинск", "Уфа", "Самара", "Екатеринбург"})

    @ParameterizedTest(name = "Set City {0}")
    void  setCitiOnWorldWeatherSite(String cityName){
        open(baseUrl);
       $("#search-field").setValue(cityName).pressEnter();
        $(byText(String.valueOf(cityName))).click();
    }
}
