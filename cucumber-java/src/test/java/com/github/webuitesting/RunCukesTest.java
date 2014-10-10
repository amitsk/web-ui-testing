package com.github.webuitesting;

/**
 * Created by amit on 10/9/14.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = false,format = {"pretty", "json:target/cucumber.json"})

public class RunCukesTest {
}
