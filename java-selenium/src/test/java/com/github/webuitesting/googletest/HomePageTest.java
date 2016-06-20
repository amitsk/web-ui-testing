package com.github.webuitesting.googletest;

import com.github.webuitesting.BaseTest;
import com.github.webuitesting.googletest.pages.HomePage;
import com.github.webuitesting.googletest.pages.SearchResults;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by amit on 6/19/16.
 */
public class HomePageTest extends BaseTest {
    @Test
    public void testBasicSearch() throws InterruptedException {

        ExtentTest extentTest = extent.startTest("Basic Google Searching");
        String baseUrl = config.getString("google.baseUrl");
        logger.info( "Now starting the test to test the URL {}", () -> baseUrl);
        HomePage homepage = new HomePage( webDriver, baseUrl);
        homepage.load();
        String searchTerm = "Selenium";
        extentTest.log(LogStatus.INFO, "Searching for term" + searchTerm);
        SearchResults searchResults = homepage.search(searchTerm);
        assertThat(searchResults.resultsLoaded());
        extentTest.log(LogStatus.PASS, "Search Returned   " + searchResults.getResultsText());
        extent.endTest(extentTest);
    }
}
