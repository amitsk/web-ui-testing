package com.github.webuitesting.googletest.pages;

import com.github.webuitesting.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.selenium.fluent.FluentWebDriver;


/**
 * Representation of Google Home Page
 */
public class HomePage extends BasePage {

    FluentWebDriver fluentWebDriver;

    @FindBy(name = "q")
    @CacheLookup
    private WebElement searchBox;

    @FindBy(name = "btnK")
    @CacheLookup
    private WebElement submitBtn;

    public HomePage(WebDriver webDriver, String baseUrl) {
        super(webDriver, baseUrl);
        fluentWebDriver = new FluentWebDriver(webDriver);
    }

    @Override
    public void load() {
        webDriver.get(baseUrl);
    }


    public void search ( String query) {
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.RETURN);
    }
}
