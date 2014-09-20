package com.github.webuitesting.pages

import org.scalatest.selenium.Page

/**
 * Created by amit on 9/20/14.
 */
class LoginPage extends Page{
  override val url: String = "http://127.0.0.1:8000/login/?next=/polls/poll/"

}
