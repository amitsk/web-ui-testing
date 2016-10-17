package com.github.webuitesting.googletest;

import com.github.webuitesting.BaseTest;
import com.github.webuitesting.googletest.pages.GooglePage;
import com.github.webuitesting.googletest.pages.SearchResultsPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 */
public class GoogleSearchTest extends BaseTest {
    @Test
    public void testBasicSearch() throws InterruptedException {

        ExtentTest extentTest = extent.startTest("Basic Google Searching");
        String baseUrl = config.getString("google.baseUrl");
        logger.info( "Now starting the test to test the URL {}", () -> baseUrl);
        GooglePage page = open(baseUrl, GooglePage.class);
        String searchTerm = "Selenium";
        extentTest.log(LogStatus.INFO, "Searching for term" + searchTerm);
        SearchResultsPage results = page.searchFor("selenide");

        results.checkResultsSize(10);
        results.results().get(0).shouldHave(text("Selenide: concise UI tests in Java"));
        extentTest.log(LogStatus.PASS, "Search Returned   " + results.results().get(0));
        extent.endTest(extentTest);
    }
}
