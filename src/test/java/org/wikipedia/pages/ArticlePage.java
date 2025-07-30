package org.wikipedia.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.wikipedia.pages.components.LanguageSelector;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ArticlePage {

    private final LanguageSelector languageSelector = new LanguageSelector();

    private final SelenideElement
        articleHeader = $("h1.firstHeading"),
        articleContent = $(byId("bodyContent"));

    @Step("Нажать на '{value}' язык в меню")
    public ArticlePage switchToLanguage(String value){
        languageSelector.switchToLanguage(value);
        return this;
    }

    @Step("Заголовок статьи содержит текст '{value}'")
    public ArticlePage articleHeaderHasText(String value){
        articleHeader.shouldHave(text(value));
        return this;
    }

    @Step("Текст статьи содержит текст '{value}'")
    public ArticlePage articlePageHasText(String value){
        articleContent.shouldHave(text(value));
        return this;
    }

}
