package org.wikipedia.tests.language;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.wikipedia.WikipediaWebTest;
import org.wikipedia.pages.MainPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

@Feature("Главная страница Wikipedia")
@DisplayName("Главная страница Wikipedia")
public class SelectingDifferentLanguagesOnMainPageFromTopLanguagesTests extends WikipediaWebTest {

    @Test
    @AllureId("70")
    @DisplayName("Открытие Wikipedia на английском языке")
    @Story("Открытие Wikipedia на разных языках")
    @Owner("sergey.dubinin.work")
    void selectingEnglishLanguageOnMainPageFromTop10() {
        step("Перейти на https://www.wikipedia.org/",
                homePage::open);
        step("Кликнуть по ссылке English",
                () -> homePage.clickTopLanguage("English"));
        step("Убедиться, что открыт сайт https://en.wikipedia.org/",
                () -> webdriver().shouldHave(url("https://en.wikipedia.org/wiki/Main_Page"))
        );
        MainPage mainPage = new MainPage();
        step("Проверить наличие заголовка Welcome to Wikipedia",
                () -> mainPage.shouldHaveContentWithText("Welcome to Wikipedia"));
    }

    @Test
    @AllureId("71")
    @DisplayName("Открытие Wikipedia на немецком языке")
    @Story("Открытие Wikipedia на разных языках")
    @Owner("sergey.dubinin.work")
    void selectingDeutschLanguageOnMainPageFromTop10() {
        step("Перейти на https://www.wikipedia.org/",
                homePage::open);
        step("Кликнуть по ссылке Deutsch",
                () -> homePage.clickTopLanguage("Deutsch"));
        step("Убедиться, что открыт сайт https://de.wikipedia.org/",
                () -> webdriver().shouldHave(url("https://de.wikipedia.org/wiki/Wikipedia:Hauptseite"))
        );
        MainPage mainPage = new MainPage();
        step("Проверить наличие заголовка Willkommen bei Wikipedia",
                () -> mainPage.shouldHaveContentWithText("Willkommen bei Wikipedia"));
    }

    @Test
    @AllureId("108")
    @DisplayName("Открытие Wikipedia на русском языке")
    @Story("Открытие Wikipedia на разных языках")
    @Owner("sergey.dubinin.work")
    void selectingRussianLanguageOnMainPageFromTop10() {
        step("Перейти на https://www.wikipedia.org/",
                homePage::open);
        step("Кликнуть по ссылке Русский",
                () -> homePage.clickTopLanguage("Русский"));
        step("Убедиться, что открыт сайт https://ru.wikipedia.org/",
                () -> webdriver().shouldHave(url("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0")));
        MainPage mainPage = new MainPage();
        step("Проверить наличие заголовка Добро пожаловать в Википедию",
                () -> mainPage.shouldHaveContentWithText("Добро пожаловать в Википедию"));
    }

}
