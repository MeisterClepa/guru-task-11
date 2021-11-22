package ru.simbirsoft.autotests.helpers;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.simbirsoft.autotests.config.App;
import ru.simbirsoft.autotests.config.Driver;

public class DriverConfiguration {

    public static void configure() {
        Configuration.browser = Driver.config.browser();
        Configuration.browserVersion = Driver.config.browserVersion();
        Configuration.browserSize = Driver.config.browserSize();
        Configuration.baseUrl = App.config.baseUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=" + Driver.config.browserLocale());
        chromeOptions.addArguments("--log-level=" + Driver.config.browserLogLevel());

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
