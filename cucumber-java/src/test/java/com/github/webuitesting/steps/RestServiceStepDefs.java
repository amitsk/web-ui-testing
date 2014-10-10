package com.github.webuitesting.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by amit on 10/9/14.
 */
public class RestServiceStepDefs {
    @Given("^there are (\\d+) cars available for rental$")
    public void there_are_cars_available_for_rental(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I rent one$")
    public void i_rent_one() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^there will only be (\\d+) cars available for rental$")
    public void there_will_only_be_cars_available_for_rental(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
