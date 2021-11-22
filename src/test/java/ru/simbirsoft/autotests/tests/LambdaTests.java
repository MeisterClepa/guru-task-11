package ru.simbirsoft.autotests.tests;


import com.codeborne.selenide.Configuration;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("Efremov Egor")
public class LambdaTests extends WebTest {

    @Tag("Critical")
    @Feature("Поиск в Google")
    @Story("Открытие Google виджетов через поисковую строку")
    @DisplayName("Открытие виджета калькулятора поисковым запросом: ")
    @ParameterizedTest(name = "{displayName} {0}")
    @ValueSource(strings = {"Calculator", "Калькулятор"})
    void searchCalcTest(String searchReq) {
        Allure.parameter("Поисковый запрос", searchReq);

        step("Открыть страницу " + Configuration.baseUrl, () ->
                open(""));

        step("В поисковую строку ввести {0} " + searchReq, () ->
                $(By.name("q")).setValue(searchReq));

        step("Нажать на кнопку поиска", () ->
                $(By.name("btnK")).click());

        step("На странице присутствует виджет калькулятора", () ->
                $(".card-section").shouldBe(visible));
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

        step("Открыть страницу калькулятора "
                + Configuration.baseUrl + "/search?q=calc", () ->
                open("/search?q=calculator"));

        step("Вычислить выражение " + inputQuery, () ->
                mapCmdToClicks(extendInput));

        step("В строке истории отображается " + extendInput, () -> {
            $("span[style='right: 0px;']").shouldHave(exactOwnText
                    (extendInput.replace('\u2212', '-')));
        });

        step("В строке результата отображается " + expectedResult, () -> {
            $("#cwos").shouldHave(text(expectedResult));
        });

    }

    private void mapCmdToClicks(String name) {
        String[] token = name.replaceAll("\\s", "").split("");
        for (String ch : token) {
            clickButton(ch);
        }
    }

    private void clickButton(String symbol) {
        step("Нажать кнопку " + symbol, () ->
                $$("td div[role='button']")
                        .find(exactText(symbol)).click());
    }
}
