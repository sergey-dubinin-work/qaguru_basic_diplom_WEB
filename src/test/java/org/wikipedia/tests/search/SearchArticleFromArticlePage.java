package org.wikipedia.tests.search;

import com.codeborne.selenide.Selenide;
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
import static org.junit.jupiter.api.Assertions.assertAll;

public class SearchArticleFromArticlePage extends WikipediaWebTest {

    @Test
    @AllureId("75")
    @DisplayName(" Поиск новой статьи со страницы другой статьи и проверка результата")
    @Story("Поиск со страницы статьи")
    @Owner("sergey.dubinin.work")
    @Feature("Поиск статей")
    void name() {
        step("Перейти на любую статью, например: https://ru.wikipedia.org/wiki/Java",
                () -> Selenide.open("https://ru.wikipedia.org/wiki/Java"));
        ArticlePage articlePage = new ArticlePage();
        step("Найти поле поиска в шапке страницы");
        step("Ввести в поле Python",
                () -> articlePage.inputInSearchField("Python"));
        step("Нажать на кнопку Искать",
                articlePage::clickSearchButton);
        step("Убедиться, что открылась страница Python, а URL корректный",
                () -> assertAll(
                        () -> webdriver().shouldHave(url("https://ru.wikipedia.org/wiki/Python")),
                        () -> articlePage.articleHeaderHasText("Python")
                ));
    }

}
