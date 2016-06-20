package com.github.webuitesting.googletest.pages;

import com.github.webuitesting.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Representation of Google Search Results
 */
public class SearchResults extends BasePage {

    @FindBy(id = "resultStats")
    @CacheLookup
    private WebElement resultStats;

    public SearchResults(WebDriver webDriver, String baseUrl) {
        super(webDriver, baseUrl);
    }

    @Override
    public void load() {

    }


}
