package org.wikipedia.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    private final SelenideElement
        searchField = $(byId("simpleSearch")).$(byTagName("input")),
        searchButton = $(byId("searchButton"));

    @Step("Ввод текста в поле поиска")
    public Header inputInSearchField(String value){
        searchField.setValue(value);
        return this;
    }

    @Step("Клик по кнопке 'Искать'")
    public Header clickSearchButton(){
        searchButton.click();
        return this;
    }

}
