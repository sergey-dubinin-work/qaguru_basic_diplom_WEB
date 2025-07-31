package org.wikipedia.tests.language;

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

@Feature("Смена языка интерфейса")
@DisplayName("Смена языка интерфейса")
public class ChangingLanguageOnArticlePageTests extends WikipediaWebTest {

    @Test
    @AllureId("72")
    @DisplayName("Смена языка статьи с русского на английский и проверка корректности перехода")
    @Story("Смена языка Wikipedia на странице статьи")
    @Owner("sergey.dubinin.work")
    void changeLanguageOnArticlePageFromRussianToEnglish() {
        step("Перейти на статью https://ru.wikipedia.org/wiki/%D0%A1%D0%B5%D1%80%D0%B8%D1%8F_%D1%80%D0%BE%D0%BC%D0%B0%D0%BD%D0%BE%D0%B2_%D0%BE_%D0%93%D0%B0%D1%80%D1%80%D0%B8_%D0%9F%D0%BE%D1%82%D1%82%D0%B5%D1%80%D0%B5",
                () -> Selenide.open("https://ru.wikipedia.org/wiki/%D0%A1%D0%B5%D1%80%D0%B8%D1%8F_%D1%80%D0%BE%D0%BC%D0%B0%D0%BD%D0%BE%D0%B2_%D0%BE_%D0%93%D0%B0%D1%80%D1%80%D0%B8_%D0%9F%D0%BE%D1%82%D1%82%D0%B5%D1%80%D0%B5"));

        ArticlePage articlePage = new ArticlePage();
        step("Проверить, что заголовок статьи на русском языке",
                () -> articlePage.articleHeaderHasText("Серия романов о Гарри Поттере"));
        step("Найти список языков в левом меню");
        step("Кликнуть по ссылке English",
                () -> articlePage.switchToLanguage("English"));
        step("Убедиться, что произошло перенаправление на https://en.wikipedia.org/wiki/Harry_Potter",
                () -> webdriver().shouldHave(url("https://en.wikipedia.org/wiki/Harry_Potter"))
                );
        step("Проверить, что заголовок статьи на английском языке",
                () -> articlePage.articleHeaderHasText("Harry Potter"));
    }

}
