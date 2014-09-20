package com.github.webuitesting

import org.openqa.selenium.firefox.FirefoxDriver
import pages.PollsHomePage
import   org.openqa.selenium._
/**
 * Created by amit on 9/20/14.
 */
class HomePageSpec extends WebBrowserBaseSpec {
  implicit val webDriver: WebDriver = new FirefoxDriver

  "The Polls app home page" should "have the correct title" in {
    val homePage = new PollsHomePage
    go to homePage
    pageTitle should contain ("poll")
  }
}
