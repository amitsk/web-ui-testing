package com.github.webuitesting

import com.github.webuitesting.pages.LoginPage
import com.github.webuitesting.pages.PollsHomePage

class LoginSpec extends BaseSpec {
    def "User can Login to the polls application "() {
        when:
            to LoginPage
            login "amit", "password"
        then:
            at PollsHomePage
    }

}