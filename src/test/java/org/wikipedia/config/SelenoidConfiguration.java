package org.wikipedia.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:selenoid.properties"
})
public interface SelenoidConfiguration extends Config {

    @Key("selenoid.url")
    String selenoidUrl();

    @Key("selenoid.port")
    String selenoidPort();

    @Key("selenoid.ui.port")
    String selenoidUIPort();

}
