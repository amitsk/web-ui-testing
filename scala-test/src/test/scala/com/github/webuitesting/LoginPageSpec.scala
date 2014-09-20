package com.github.webuitesting

import com.github.webuitesting.pages.{LoginPage, PollsHomePage}
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.scalatest.time.{Span, Seconds}

/**
 * Created by amit on 9/20/14.
 */
class LoginPageSpec extends WebBrowserBaseFeatureSpec {
  implicit val webDriver: WebDriver = new FirefoxDriver


  feature("Login") {
    scenario("User logins to the application") {

      Given("The user goes to the login page")
      val loginPage = new LoginPage
      go to loginPage

      When("Enter credentials and click login")
      val userNameField = textField(cssSelector("input#id_username"))
      val passwordField = pwdField(cssSelector("input#id_password"))
      val submitButton = find("div.submit-row>input").get
      userNameField.value = "amit"
      passwordField.value = "password"
      click on submitButton

      Then("User is logged in to the website")
        pageTitle contains("poll")
    }
  }

}
