package org.wikipedia.helpers.browserSetup.impl;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.wikipedia.helpers.SelenoidUtils;
import org.wikipedia.helpers.browserSetup.BrowserSetup;

import java.util.Map;

public class ChromeSetup implements BrowserSetup {

    @Override
    public void configureWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public void configureBrowser() {
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", Map.of("intl.accept_languages", "en"));

        options.setCapability("selenoid:options", SelenoidUtils.getSelenoidCapabilities());

        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

}
