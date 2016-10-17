package com.github.webuitesting.googletest.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    public void checkResultsSize(int expectedSize) {
        results().shouldHave(size(expectedSize));
    }

    public void checkResults(String... expectedTexts) {
        results().shouldHave(texts(expectedTexts));
    }

    public ElementsCollection results() {
        return $$("#ires .g");
    }

}