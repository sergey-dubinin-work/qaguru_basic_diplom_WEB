package org.wikipedia;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.wikipedia.helpers.AllureAttachments;
import org.wikipedia.helpers.WebDriverConfigurator;
import org.wikipedia.helpers.WebDriverUtils;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.util.Objects.isNull;
import static org.wikipedia.config.ConfigurationManager.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        WebDriverConfigurator.configure();
    }

    @AfterEach
    void tearDown() {
        String sessionId = null;

        if (!isNull(getSelenoidConfig().selenoidUrl())) {
            sessionId = WebDriverUtils.getSessionId();
        }

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();

        if ("chrome".equals(getBrowserConfig().browserName())) {
            AllureAttachments.addBrowserConsoleLogs();
        }

        closeWebDriver();

        if (!isNull(getSelenoidConfig().selenoidUrl())){
            AllureAttachments.addVideo(sessionId);
            AllureAttachments.addAutoplayVideo(sessionId);
        }

    }

}