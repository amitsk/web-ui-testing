package com.github.webuitesting.googletest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GooglePage {

    public SearchResultsPage searchFor(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(SearchResultsPage.class);
    }
}
