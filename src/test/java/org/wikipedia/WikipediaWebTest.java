package org.wikipedia;

import com.codeborne.selenide.Configuration;
import org.wikipedia.pages.HomePage;

public class WikipediaWebTest extends TestBase{

    protected HomePage homePage = new HomePage();

    static {
        Configuration.baseUrl = "https://wikipedia.org/";
    }
}
