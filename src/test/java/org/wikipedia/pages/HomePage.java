package org.wikipedia.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static final SelenideElement
        logo = $(byClassName("central-textlogo-wrapper")),
        langListButton = $(byId("js-lang-list-button")),
        searchBar = $(byId("searchInput")),
        topLanguagesBlock = $(byClassName("central-featured"));

    @Step("Открытие главной страницы")
    public HomePage open(){
        Selenide.open("");
        return this;
    }

    @Step("Проверка наличия логотипа")
    public HomePage shouldHaveLogo(){
        logo.shouldBe(visible);
        return this;
    }

    @Step("Проверка наличия кнопки со списком языков")
    public HomePage shouldHaveLanguageListButton(){
        langListButton.shouldBe(visible);
        return this;
    }

    @Step("Проверка текста на кнопке списка языков")
    public HomePage languageListShouldHaveText(String value){
        langListButton.shouldHave(text(value));
        return this;
    }

    @Step("Проверка наличия строки поиска")
    public HomePage shouldHaveSearchBar(){
        searchBar.shouldBe(visible);
        return this;
    }

    @Step("Проверка, что блок 'Популярные языки' содержит текст {value}")
    public HomePage topLanguagesContain(String value){
        topLanguagesBlock.shouldHave(text(value));
        return this;
    }

}
