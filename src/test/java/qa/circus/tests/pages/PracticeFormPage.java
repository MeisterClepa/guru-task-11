package qa.circus.tests.pages;


import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private SelenideElement fieldByPlaceholder(String placeholder) {
        return $$("[class$='form-control']")
                .find(attribute("placeholder", placeholder))
                .shouldBe(visible);
    }

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage setName(String name) {
        fieldByPlaceholder("First Name").setValue(name);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        fieldByPlaceholder("Last Name").setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        fieldByPlaceholder("name@example.com").setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        $$("[for^='gender-radio']").find(exactTextCaseSensitive(gender))
                .shouldBe(visible)
                .click();
        return this;
    }

    public PracticeFormPage setMobile(String phone) {
        fieldByPlaceholder("Mobile Number").setValue(phone);
        return this;
    }

    public PracticeFormPage setHobby(String hobby) {
        $$("[for^='hobbies-checkbox']").find(exactTextCaseSensitive(hobby))
                .shouldBe(visible)
                .click();
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        fieldByPlaceholder("Current Address").setValue(address);
        return this;
    }

    public PracticeFormPage setImage(File image) {
        $("#uploadPicture").shouldBe(visible).uploadFile(image);
        return this;
    }

    public PracticeFormPage submit() {
        $("#submit").scrollTo().shouldBe(visible).click();
        return this;
    }

    public PracticeFormPage setCurMonthCal(String day, String month, String year) {
        $("#dateOfBirthInput").shouldBe(visible).click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        //use only the current month`s options
        $$(".react-datepicker__day").find(text(day)).click();
        return this;
    }

    public PracticeFormPage fillSubjectAutoComply(String subject, int beginLetter, int endLetter) {
        String shortForm = subject.substring(beginLetter, endLetter);
        $("#subjectsInput").setValue(shortForm).pressEnter();
        return this;
    }


    public PracticeFormPage setState(String value) {
        $("#react-select-3-input").setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        $("#react-select-4-input").setValue(value).pressEnter();
        return this;
    }

    public void assertFormTable(String[] assertArray) {
        $$("table tr td:nth-child(2)").shouldHave(exactTexts(assertArray));
    }
}