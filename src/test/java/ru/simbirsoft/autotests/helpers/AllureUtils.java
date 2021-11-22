package ru.simbirsoft.autotests.helpers;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllureUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(AllureUtils.class);

    @Attachment(value = "Browser console logs", type = "text/plain")
    public static String attachBrowserConsoleLogs() {
        return DriverUtils.getConsoleLogs();
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshotAs(String attachName) {
        return DriverUtils.getScreenshotAsBytes();
    }

    @Attachment(value = "Page source", type = "text/html")
    public static byte[] attachPageSource() {
        return DriverUtils.getPageSourceAsBytes();
    }
}
