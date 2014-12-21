package com.github.webuitesting.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.github.webuitesting.config.TestConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.github.webuitesting.util.PropertyLoader;
import com.github.webuitesting.util.Browser;
import com.github.webuitesting.webdriver.WebDriverFactory;

/*
 * Base class for all the test classes
 * 
 * @author Sebastiano Armeli-Battana
 */
@ContextConfiguration( classes = { TestConfiguration.class} )
public class TestBase extends AbstractTestNGSpringContextTests {
	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";

	protected WebDriver webDriver;

	protected String gridHubUrl;
	@Value("${page.url}")
	protected String websiteUrl;

	protected Browser browser;
	@Value("${browser.name}")
	protected String browserName;

	@BeforeClass
	public void init() {
		//websiteUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

		browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");
		
		webDriver = WebDriverFactory.getInstance(gridHubUrl, browser, username,
				password);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

//	@AfterMethod
//	public void setScreenshot(ITestResult result) {
//		if (!result.isSuccess()) {
//			try {
//				WebDriver returned = new Augmenter().augment(webDriver);
//				if (returned != null) {
//					File f = ((TakesScreenshot) returned)
//							.getScreenshotAs(OutputType.FILE);
//					try {
//						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
//								+ result.getName() + SCREENSHOT_FORMAT));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			} catch (ScreenshotException se) {
//				se.printStackTrace();
//			}
//		}
//	}
}
