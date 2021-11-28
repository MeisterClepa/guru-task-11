package qa.circus.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import qa.circus.helpers.AllureUtils;
import qa.circus.helpers.DriverConfiguration;


public class WebTest {

    @BeforeAll
    static void driverSetUp() {
        DriverConfiguration.configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        AllureUtils.attachScreenshotAs("Last step screenshot");
        AllureUtils.attachPageSource();
        AllureUtils.attachBrowserConsoleLogs();
        AllureUtils.attachRemoteVideo();
        Selenide.closeWebDriver();

    }
}
