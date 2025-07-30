package org.wikipedia.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class LanguageSelector {

    private final SelenideElement
        languagesBlock = $(byId("p-lang"));

    private final ElementsCollection
        languages = languagesBlock.$$("li.interlanguage-link");

    @Step("Нажать на '{value}' язык в меню")
    public LanguageSelector switchToLanguage(String value){
        languages
                .findBy(text(value))
                .$(byTagName("a"))
                .click();
        return this;
    }

}
