package qa.circus.helpers;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static qa.circus.helpers.DriverUtils.getSessionId;
import static qa.circus.helpers.DriverUtils.getVideoUrl;

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

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String attachRemoteVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl(getSessionId())
                + "' type='video/mp4'></video></body></html>";
    }


}
