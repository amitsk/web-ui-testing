package com.github.webuitesting.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * Factory to instantiate a WebDriver object. It returns an instance of the driver
 * Only Chrome and FIrefox are supported.
 */
public class WebDriverFactory {

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    private WebDriverFactory(){}

    public static WebDriver getDriver(String browser) {

        WebDriver webDriver = null;

        if (CHROME.equals(browser)) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            webDriver = new ChromeDriver(capabilities);
        } else if (FIREFOX.equals(browser)) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);

            System.setProperty("webdriver.firefox.marionette","true");
            webDriver = new MarionetteDriver(capabilities);
        }

        return webDriver;
    }
}
