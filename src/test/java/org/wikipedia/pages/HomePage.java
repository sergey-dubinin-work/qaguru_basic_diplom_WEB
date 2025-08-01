package org.wikipedia.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    private final SelenideElement
        logo = $(byClassName("central-textlogo-wrapper")),
        langListButton = $(byId("js-lang-list-button")),
        searchBar = $(byId("searchInput")),
        topLanguagesBlock = $(byClassName("central-featured")),
        searchButton = $(byText("Search"));

    private final ElementsCollection
        topLanguages = $$(byClassName("central-featured-lang"));

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

    @Step("Ввод текста в строку поиска")
    public HomePage inputInSearchBar(String value){
        shouldHaveSearchBar();
        searchBar.setValue(value);
        return this;
    }

    @Step("Нажатие на кнопку Поиск")
    public HomePage clickSearch(){
        searchButton.click();
        return this;
    }

    @Step("Проверка, что блок 'Популярные языки' содержит текст {value}")
    public HomePage topLanguagesContain(String value){
        topLanguagesBlock.shouldHave(text(value));
        return this;
    }

    @Step("Нажатие на '{value}' язык из списка TOP10")
    public HomePage clickTopLanguage(String value){
        topLanguages
                .findBy(text(value))
                .shouldBe(visible)
                .click();
        return this;
    }

}
