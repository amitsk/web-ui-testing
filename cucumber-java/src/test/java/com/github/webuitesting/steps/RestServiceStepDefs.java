package com.github.webuitesting.steps;

import com.jayway.restassured.RestAssured;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by amit on 10/9/14.
 */
public class RestServiceStepDefs {

    private Integer id;


    @When("^client requests GET /snippets/(\\d+)$")
    public void client_requests_GET_snippets(int arg1) throws Throwable {
        RestAssured.baseURI = "http://127.0.0.1";
        RestAssured.port = 8000;
        id = given().log().all().get("/snippets/1").jsonPath().getInt("id");
    }

    @Then("^the response is a snippet with id (\\d+)$")
    public void the_response_is_a_snippet_with_attribute(Integer id) throws Throwable {
        Assert.assertThat(id, is(id));
    }

}
