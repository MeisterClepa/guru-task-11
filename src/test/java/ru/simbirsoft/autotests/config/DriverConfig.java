package ru.simbirsoft.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:driver.properties",
})
public interface DriverConfig extends Config {

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("92.0")
    String browserVersion();

    @DefaultValue("1680x1050")
    String browserSize();

    @DefaultValue("en-en")
    String browserLocale();

    @DefaultValue("1")
    String browserLogLevel();
}