package com.github.webuitesting

import org.scalatest._

import org.scalatest.selenium.WebBrowser

/**
 * Created by amit on 9/20/14.
 */
abstract class WebBrowserBaseSpec extends FlatSpec with Matchers with GivenWhenThen with WebBrowser
with BeforeAndAfterAll with BeforeAndAfter
