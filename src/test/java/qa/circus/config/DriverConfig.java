package qa.circus.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:driver.properties",
})
public interface DriverConfig extends Config {

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("91.0")
    String browserVersion();

    @DefaultValue("1680x1050")
    String browserSize();

    @DefaultValue("en-en")
    String browserLocale();

    @DefaultValue("1")
    String browserLogLevel();

    @DefaultValue("")
    String selenoidUrl();

    @DefaultValue("")
    String login();

    @DefaultValue("")
    String pwd();

    @DefaultValue("https://${login}:${pwd}@${selenoidUrl}")
    String remoteUrl();

    @DefaultValue("")
    String videoStorage();

    @DefaultValue("${remoteUrl}/wd/hub")
    String remoteWebdriverUrl();

    @DefaultValue("${remoteUrl}/video/")
    String remoteVideoUrl();

}