package com.github.webuitesting.pages

class LoginPage extends BasePage {

    static url = "/admin/polls/poll/"
    static at = { title.contains ("Log in" ) }
    static content = {
        userNameField  { $("input#id_username") }
        passwordField  { $("input#id_password")  }
        submit    { $("div.submit-row>input") }
    }

    void login( String userName, String password) {
        userNameField.value userName
        passwordField.value password
        submit.click()
    }

}