package org.wikipedia.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static SelenoidConfiguration getSelenoidConfig(){
        return ConfigCache.getOrCreate(SelenoidConfiguration.class);
    }

    public static BrowserConfiguration getBrowserConfig(){
        return ConfigCache.getOrCreate(BrowserConfiguration.class);
    }

}
