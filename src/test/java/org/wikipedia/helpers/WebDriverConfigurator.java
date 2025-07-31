package org.wikipedia.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.wikipedia.helpers.browserSetup.BrowserFactory;
import org.wikipedia.helpers.browserSetup.BrowserSetup;

import static java.util.Objects.isNull;
import static org.wikipedia.config.ConfigurationManager.getBrowserConfig;
import static org.wikipedia.config.ConfigurationManager.getSelenoidConfig;

public class WebDriverConfigurator {

    public static void configure(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        BrowserSetup browserSetup = BrowserFactory.getBrowserSetup();

        if (isNull(getSelenoidConfig().selenoidUrl())){
            browserSetup.configureWebDriverManager();
        } else {
            Configuration.remote = String.format(
                    "%s:%s/wd/hub",
                    getSelenoidConfig().selenoidUrl(),
                    getSelenoidConfig().selenoidPort()
            );
        }

        Configuration.browser = getBrowserConfig().browserName();
        Configuration.browserSize = getBrowserConfig().browserSize();

        browserSetup.configureBrowser();

    }

}
