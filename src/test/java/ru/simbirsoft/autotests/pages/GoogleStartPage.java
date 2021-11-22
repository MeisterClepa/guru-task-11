package ru.simbirsoft.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoogleStartPage {

    private SelenideElement getCalcButton(String symbol) {
        return $$("td div[role='button']").find(exactText(symbol));
    }

    @Step("Открыть страницу google.com")
    public GoogleStartPage openPage() {
        open("");
        return this;
    }

    @Step("В поисковую строку ввести {0}")
    public GoogleStartPage fillSearchField(String searchQuery) {
        $(By.name("q")).setValue(searchQuery);
        return this;
    }

    @Step("Нажать на кнопку поиска")
    public GoogleStartPage submitSearch() {
        $(By.name("btnK")).click();
        return this;
    }

    @Step("На странице присутствует виджет калькулятора")
    public void assertSearchedCalc() {
        $(".card-section").shouldBe(visible);
    }

}

