package org.wikipedia.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class DriverSettings {

    public static void configure(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        WebDriverManager.chromedriver().setup();

        Configuration.baseUrl = "https://wikipedia.org/";
        Configuration.browserSize = "1920x1080";
//        Configuration.remote = String.format(
//                "%s:%s/wd/hub",
//                getSelenoidConfig().selenoidUrl(),
//                getSelenoidConfig().selenoidPort()
//        );

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", Map.of("intl.accept_languages", "en"));

//        options.setCapability("selenoid:options", new HashMap<String, Object>() {
//                    {
//                        put("enableVNC", true);
//                        put("enableVideo", true);
//                    }
//                }
//        );

        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

}
