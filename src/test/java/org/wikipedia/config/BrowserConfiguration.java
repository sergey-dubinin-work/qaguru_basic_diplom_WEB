package org.wikipedia.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:browser.properties"
})
public interface BrowserConfiguration extends Config {

    @Key("browserName")
    @DefaultValue("chrome")
    String browserName();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
}
