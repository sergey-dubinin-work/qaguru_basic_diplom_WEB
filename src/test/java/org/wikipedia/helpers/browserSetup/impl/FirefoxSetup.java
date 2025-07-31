package org.wikipedia.helpers.browserSetup.impl;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.wikipedia.helpers.SelenoidUtils;
import org.wikipedia.helpers.browserSetup.BrowserSetup;

public class FirefoxSetup implements BrowserSetup {

    @Override
    public void configureWebDriverManager() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    public void configureBrowser() {
        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("intl.accept_languages", "en");

        options.setCapability("selenoid:options", SelenoidUtils.getSelenoidCapabilities());

        Configuration.browserCapabilities = options;
    }

}
