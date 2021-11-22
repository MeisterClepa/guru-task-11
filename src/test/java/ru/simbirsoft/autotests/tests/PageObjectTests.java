package ru.simbirsoft.autotests.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.simbirsoft.autotests.pages.GoogleCalculatorPage;
import ru.simbirsoft.autotests.pages.GoogleStartPage;

@Owner("Efremov Egor")
public class PageObjectTests extends WebTest {

    private final GoogleStartPage startSearchPage = new GoogleStartPage();
    private final GoogleCalculatorPage googleCalcPage = new GoogleCalculatorPage();

    @Tag("Critical")
    @Feature("Поиск в Google")
    @Story("Открытие Google виджетов через поисковую строку")
    @DisplayName("Открытие виджета калькулятора поисковым запросом: ")
    @ParameterizedTest(name = "{displayName} {0}")
    @ValueSource(strings = {"Calculator", "Калькулятор"})
    void searchCalcTest(String searchReq) {
        Allure.parameter("Поисковый запрос", searchReq);

        startSearchPage.openPage()
                .fillSearchField(searchReq)
                .submitSearch()
                .assertSearchedCalc();
    }

    @Tag("Critical")
    @Feature("Работа c Google калькулятором")
    @Story("Выполнение примитивных числовых операций")
    @DisplayName("Вычисление выражения: ")
    @ParameterizedTest(name = "{displayName} {0}")
    @CsvSource(value = {
            "1 × 2 − 3 + 1||0",
            "1 × 2 − 3 + 2||1"},
            delimiterString = "||")
    void primitiveCalcTest(String inputQuery, String expectedResult) {
        Allure.parameter("Входное мат. выражение", inputQuery);
        Allure.parameter("Ожидамое вычисленное значение", expectedResult);

        String extendInput = inputQuery + " =";
        googleCalcPage.openPage()
                .sendMathExpr(extendInput)
                .assertHistory(extendInput.replace('\u2212', '-'))
                .assertResult(expectedResult);

    }
}
