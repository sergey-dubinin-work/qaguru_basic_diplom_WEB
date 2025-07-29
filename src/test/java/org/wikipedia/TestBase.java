package org.wikipedia;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.wikipedia.helpers.AllureAttachments;
import org.wikipedia.helpers.DriverSettings;
import org.wikipedia.helpers.DriverUtils;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
    }

    @AfterEach
    void tearDown() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        closeWebDriver();

//        AllureAttachments.addVideo(sessionId);
        AllureAttachments.addAutoplayVideo(sessionId);
    }

}
