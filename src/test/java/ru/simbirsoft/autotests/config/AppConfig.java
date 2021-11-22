package ru.simbirsoft.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:app.properties",
})
public interface AppConfig extends Config {

    String baseUrl();
}