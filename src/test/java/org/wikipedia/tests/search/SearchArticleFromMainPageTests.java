package org.wikipedia.tests.search;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.wikipedia.WikipediaWebTest;
import org.wikipedia.pages.ArticlePage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

@Feature("Поиск статей")
@DisplayName("Поиск статей")
public class SearchArticleFromMainPageTests extends WikipediaWebTest {

    @Test
    @AllureId("73")
    @DisplayName("Поиск существующей статьи с главной страницы")
    @Story("Поиск с главной страницы")
    @Owner("sergey.dubinin.work")
    void searchExistingArticleFromMainPage() {
        step("Перейти на https://www.wikipedia.org/",
                homePage::open);
        step("Ввести в поле поиска текст Selenide",
                () -> homePage.inputInSearchBar("Selenide"));
        step("Нажать Enter или кликнуть по кнопке поиска",
                () -> homePage.clickSearch());
        ArticlePage articlePage = new ArticlePage();
        step("Убедиться, что открылась статья Selenide (проверка заголовка, URL)",
                () -> {
                    webdriver().shouldHave(url("https://en.wikipedia.org/wiki/Selenide"));
                    articlePage.articleHeaderHasText("Selenide");
                });
    }

    @Test
    @AllureId("74")
    @DisplayName("Поиск несуществующей статьи и проверка сообщения об ошибке")
    @Story("Поиск с главной страницы")
    @Owner("sergey.dubinin.work")
    void searchNotExistingArticleFromMainPage() {
        step("Перейти на сайт https://www.wikipedia.org/",
                homePage::open);
        step("Убедиться, что отображается поле поиска");
        step("Ввести в поле поиска строку asdlkfjasdlfkj (набор случайных символов, заведомо несуществующее название)",
                () -> homePage.inputInSearchBar("asdlkfjasdlfkj"));
        step("Нажать Enter или кнопку поиска",
                () -> homePage.clickSearch());
        ArticlePage articlePage = new ArticlePage();
        step("Дождаться загрузки страницы с результатами поиска",
                () -> {
                    articlePage.articleHeaderHasText("Search results");
                    articlePage.articlePageHasText("There were no results matching the query.");
                });
    }

}
