package com.github.webuitesting.pages

class LoginPage extends BasePage {

    static url = "/login/?next=/polls/poll/"
    static at = { title == "Google" }
    static content = {
        searchField { $("input[name=q]") }
        searchButton(to: GoogleResultsPage) { $("input[value='Google Search']") }
    }

}