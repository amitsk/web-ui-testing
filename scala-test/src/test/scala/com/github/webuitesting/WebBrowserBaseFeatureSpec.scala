package com.github.webuitesting

import org.scalatest.selenium.WebBrowser
import org.scalatest._

/**
 * Created by amit on 9/20/14.
 */
abstract class WebBrowserBaseFeatureSpec extends FeatureSpec with
  GivenWhenThen with Matchers with WebBrowser
