package qa.circus.helpers;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.circus.config.App;
import qa.circus.config.Driver;

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

        if (Driver.isRemoteWebDriver()) {
            if (Driver.isVideoOn()){
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
            }
            Configuration.remote = Driver.config.remoteWebdriverUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
