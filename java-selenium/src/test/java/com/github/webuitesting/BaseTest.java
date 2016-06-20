package com.github.webuitesting;

import com.github.webuitesting.util.WebDriverFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Base class for tests. Common initialization logic for Webdriver.
 */
public class BaseTest {

    static final String extentReportLocation = "target/extentreports/";
    protected final ExtentReports extent = new ExtentReports (extentReportLocation + this.getClass().getName() + ".html");
    protected WebDriver webDriver;
    protected static Config config;
    protected Logger logger = LogManager.getLogger(this.getClass());

    @BeforeClass
    public static void setupEnvironmentConfig() {
        Config baseConfig = ConfigFactory.load("application");//Explicitly named, default is also application.conf
        String env = baseConfig.getString("environment");
        if (env == null ) {
            throw new IllegalArgumentException("Please specify an environment. Valid values are local,test,prod");
        }
        if ( config == null ||  ! config.isResolved() ) {
            config = ConfigFactory.load(env).withFallback(baseConfig);
        }
    }

    @AfterClass
    public static void tearDown() {

    }

    @Before
    public void init() {
        webDriver = WebDriverFactory.getDriver( config.getString("browser.name"));
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void doCleanUp() {
        extent.flush();
        extent.close();
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
