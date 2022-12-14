package rf.fkkf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WorldWeatherSiteTest extends BaseTest {

    @ValueSource(strings = {"Санкт-Петербург", "Пермь", "Южно-Сахалинск", "Уфа", "Самара", "Екатеринбург"})
    @DisplayName("Set City from list on the Search Page")
    @ParameterizedTest(name = "Set City {0}")
    void setCityOnWorldWeatherSite(String cityName) {
        open(baseUrl);
        $("#search-field").setValue(cityName).pressEnter();
        $(byText(String.valueOf(cityName))).click();
    }

    @CsvFileSource(resources = "/SelectCity.csv", delimiter = '|')
    @DisplayName("Select City from Drop-down List  Search Field ")
    @ParameterizedTest(name = "Select City {0} of List {1}")
    void selectCityOnWorldWeatherSite(String cityName, String cityCopmplit) {
        open(baseUrl);
        $("#search-field").setValue(cityName);
        $(byText(String.valueOf(cityCopmplit))).click();
    }

    private static Stream<Arguments> selectCityForWorldWeatherSite() {
        return Stream.of(
                Arguments.of("Париж", "Россия, Башкортостан, Кигинский район"),
                Arguments.of("Париж", "Россия, Челябинская область, Нагайбакский район"),
                Arguments.of("Самара", "Россия, Самарская область"),
                Arguments.of("Самара", "Россия, Ленинградская область, Тихвинский район")
        );
    }

    @MethodSource("selectCityForWorldWeatherSite")
    @ParameterizedTest(name = "Выбор города {0} в соответствии с регионом {1}")
    void selectCityOfRegionFWorldWeatherSite(String cityName, String cityCopmplit) {
        open(baseUrl);
        $("#search-field").setValue(cityName);
        $(byText(String.valueOf(cityCopmplit))).click();

    }
}
