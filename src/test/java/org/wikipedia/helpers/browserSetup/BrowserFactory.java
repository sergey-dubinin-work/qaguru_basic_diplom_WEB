package org.wikipedia.helpers.browserSetup;

import org.wikipedia.helpers.browserSetup.impl.ChromeSetup;
import org.wikipedia.helpers.browserSetup.impl.FirefoxSetup;
import org.wikipedia.helpers.browserSetup.impl.EdgeSetup;

import static org.wikipedia.config.ConfigurationManager.getBrowserConfig;

public class BrowserFactory {

    public static BrowserSetup getBrowserSetup(){
        return switch (getBrowserConfig().browserName()) {
            case "chrome" -> new ChromeSetup();
            case "firefox" -> new FirefoxSetup();
            case "edge" -> new EdgeSetup();
            default ->
                    throw new IllegalArgumentException(String.format("Not supported browser '%s'!", getBrowserConfig().browserName()));
        };

    }

}
