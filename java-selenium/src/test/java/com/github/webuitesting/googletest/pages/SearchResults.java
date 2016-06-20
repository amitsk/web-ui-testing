package com.github.webuitesting.googletest.pages;

import com.github.webuitesting.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * Representation of Google Search Results
 */
public class SearchResults extends BasePage<SearchResults> {

    @FindBy(id = "resultStats")
    @CacheLookup
    private WebElement resultStats;

    public SearchResults(WebDriver webDriver, String baseUrl) {
        super(webDriver, baseUrl);
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        assertThat(resultsLoaded());
    }

    public Boolean resultsLoaded() {
        return getResultsText().matches("About.*results.*");
    }

    public String getResultsText() {
        return resultStats.getText();
    }

}
