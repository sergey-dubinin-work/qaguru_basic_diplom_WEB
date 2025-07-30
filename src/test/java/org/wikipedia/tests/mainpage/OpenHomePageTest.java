package org.wikipedia.tests.mainpage;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.wikipedia.WikipediaWebTest;

import static io.qameta.allure.Allure.step;

@Feature("Главная страница Wikipedia")
@DisplayName("Главная страница Wikipedia")
public class OpenHomePageTest extends WikipediaWebTest {

    @Test
    @AllureId("68")
    @DisplayName("Открытие главной страницы Wikipedia на языке по умолчанию")
    @Story("Открытие главной страницы")
    @Owner("sergey.dubinin.work")
    void openingHomePageWithDefaultLanguageTest() {
        step("Открыть URL https://www.wikipedia.org/",
                homePage::open);
        step("Убедиться, что отображается логотип Wikipedia",
                homePage::shouldHaveLogo);
        step("Проверить, что текущий язык — по умолчанию Английский",
                () -> homePage.languageListShouldHaveText("Read Wikipedia in your language "));
    }

    @Test
    @AllureId("69")
    @DisplayName("Проверка наличия основных блоков на главной странице (поиск, выбор языка, список ссылок)")
    @Story("Открытие главной страницы")
    @Owner("sergey.dubinin.work")
    void checkMainBlocksOnMainPage() {
        step("Перейти на https://www.wikipedia.org/",
                homePage::open);
        step("Убедиться, что отображается поле поиска",
                homePage::shouldHaveSearchBar);
        step("Убедиться, что отображается блок выбора языка",
                homePage::shouldHaveLanguageListButton);
        step("Проверить наличие ссылок на популярные языки (например, English, Русский, Deutsch и т.п.)",
                () -> homePage
                        .topLanguagesContain("English")
                        .topLanguagesContain("Русский")
                        .topLanguagesContain("Deutsch")
                        .topLanguagesContain("Français")
                        .topLanguagesContain("Italiano")
        );
    }

}
