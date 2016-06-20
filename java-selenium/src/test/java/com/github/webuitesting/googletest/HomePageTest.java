package com.github.webuitesting.googletest;

import com.github.webuitesting.BaseTest;
import com.github.webuitesting.googletest.pages.HomePage;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by amit on 6/19/16.
 */
public class HomePageTest extends BaseTest {
    @Test
    public void testDivExisting() throws InterruptedException {

        ExtentTest extentTest = extent.startTest("Test Div Existing");
        String baseUrl = config.getString("google.baseUrl");
        logger.info( "Now starting the test to test the URL {}", () -> baseUrl);
        HomePage homepage = new HomePage( webDriver, baseUrl);
        homepage.load();
        homepage.search("Selenium");
        extent.endTest(extentTest);
    }
}
