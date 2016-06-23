package com.github.webuitesting;

import com.codeborne.selenide.Configuration;
import com.relevantcodes.extentreports.ExtentReports;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Configuration.AssertionMode.SOFT;

/**
 * Base class for tests. Common initialization logic for Webdriver.
 */
public class BaseTest {

    static final String extentReportLocation = "build/extentreports/";
    protected final ExtentReports extent = new ExtentReports (extentReportLocation + this.getClass().getName() + ".html");
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

        Configuration.timeout = 3000;
        Configuration.browser =  config.getString("browser.name");
    }


    @After
    public void doCleanUp() {
        extent.flush();
        extent.close();
    }
}
