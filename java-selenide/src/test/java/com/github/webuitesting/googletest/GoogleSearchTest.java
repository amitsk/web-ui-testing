package com.github.webuitesting.googletest;

import com.github.webuitesting.BaseTest;
import com.github.webuitesting.googletest.pages.GooglePage;
import com.github.webuitesting.googletest.pages.SearchResultsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 */
public class GoogleSearchTest extends BaseTest {
    @Test
    @DisplayName("Execute a search on Google")
    public void executeBasicSearchFlow() throws InterruptedException {
        String baseUrl = config.getString("google.baseUrl");
        logger.info( "Now starting the test to test the URL {}", baseUrl);
        GooglePage page = open(baseUrl, GooglePage.class);
        SearchResultsPage results = page.searchFor("selenide");

        results.checkResultsSize(10);
        results.results().get(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
