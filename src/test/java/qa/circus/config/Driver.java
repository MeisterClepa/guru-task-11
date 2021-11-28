package qa.circus.config;

import org.aeonbits.owner.ConfigFactory;

public class Driver {
    public static DriverConfig config = ConfigFactory.create(DriverConfig.class);

    public static boolean isRemoteWebDriver() {
        return !config.selenoidUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }

}
