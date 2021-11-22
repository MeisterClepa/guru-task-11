package ru.simbirsoft.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class GoogleCalculatorPage {

    @Step("Открыть страницу калькулятора")
    public GoogleCalculatorPage openPage() {
        open("/search?q=calculator");
        return this;
    }

    @Step("Вычислить выражение {0}")
    public GoogleCalculatorPage sendMathExpr(String expr) {
        String[] token = expr.replaceAll("\\s", "").split("");
        for (String ch : token) {
            clickButton(ch);
        }
        return this;
    }

    @Step("В строке истории отображается {0}")
    public GoogleCalculatorPage assertHistory(String history) {
        $("span[style='right: 0px;']").shouldHave(exactOwnText
                (history.replace('\u2212', '-')));
        return this;
    }

    @Step("В строке истории отображается {0}")
    public void assertResult(String expectedResult) {
        $("#cwos").shouldHave(text(expectedResult));
    }

    @Step("Нажать кнопку {0}")
    private void clickButton(String symbol) {
        step("Нажать кнопку " + symbol, () ->
                $$("td div[role='button']")
                        .find(exactText(symbol)).click());
    }
}
