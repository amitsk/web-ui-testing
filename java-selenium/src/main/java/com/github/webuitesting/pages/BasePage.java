package com.github.webuitesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.seleniumhq.selenium.fluent.FluentWebDriver;


/*
 * Abstract class representation of a Page in the UI. Page object pattern

 */
public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T>{

	protected WebDriver webDriver;
    protected FluentWebDriver fluentWebDriver;

	protected String baseUrl;
	/*
	 * Constructor injecting the WebDriver interface
	 * @param webDriver
	 */
	public BasePage(WebDriver webDriver, String baseUrl) {
		this.webDriver = webDriver;
        fluentWebDriver = new FluentWebDriver(webDriver);
		this.baseUrl = baseUrl;
        PageFactory.initElements(webDriver, this);
	}

}
