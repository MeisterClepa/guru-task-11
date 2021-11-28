package qa.circus.tests;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import qa.circus.tests.data.PracticeFormData;
import qa.circus.tests.pages.PracticeFormPage;

@Owner("Efremov Egor")
public class StudentFormTests extends WebTest {

    private final PracticeFormPage formPage = new PracticeFormPage();
    private final PracticeFormData formData = new PracticeFormData();

    @Tag("Critical")
    @Feature("Регистрация студента")
    @Story("Заполнение формы регистрации студента")
    @DisplayName("Заполнение формы регистрации студента")
    @Test
    public void studentFillFormTest() {
        formPage.openPage()
                .setName(formData.firstName)
                .setLastName(formData.lastName)
                .setEmail(formData.email)
                .setGender(formData.gender)
                .setMobile(formData.phone)
                .setCurMonthCal(formData.day, formData.month, formData.year)
                .fillSubjectAutoComply(formData.subject, 1, 4)
                .setHobby(formData.hobby)
                .setAddress(formData.address)
                .setState(formData.state)
                .setCity(formData.city)
                .submit()
                .assertFormTable(formData.assertTable);
    }
}
