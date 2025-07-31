package org.wikipedia.helpers.browserSetup.impl;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeOptions;
import org.wikipedia.helpers.SelenoidUtils;
import org.wikipedia.helpers.browserSetup.BrowserSetup;

import java.util.Map;

public class EdgeSetup implements BrowserSetup {

    @Override
    public void configureWebDriverManager() {
        WebDriverManager.edgedriver().setup();
    }

    @Override
    public void configureBrowser() {
        EdgeOptions options = new EdgeOptions();

        options.setExperimentalOption("prefs", Map.of("intl.accept_languages", "en"));

        options.setCapability("selenoid:options", SelenoidUtils.getSelenoidCapabilities());

        Configuration.browserCapabilities = options;
    }
}
