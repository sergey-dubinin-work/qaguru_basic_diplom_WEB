package org.wikipedia.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement
        pageContent = $(byId("mw-content-text"));

    @Step("Проверка, что заголовок страницы содержит текст '{value}'")
    public MainPage shouldHaveContentWithText(String value){
        pageContent
                .shouldHave(text(value));
        return this;
    }

}
