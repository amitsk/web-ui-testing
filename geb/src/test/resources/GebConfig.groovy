import org.openqa.selenium.firefox.FirefoxDriver

//http://www.gebish.org/manual/current/configuration.html#configurationr

// default is to use firefox
driver = { new FirefoxDriver() }

/*environments {
    'remote' {
        driver = {
            new RemoteWebDriver(new URL("http://windows.ci-server.local"), DesiredCapabilities.internetExplorer())
        }
    }
}*/

waiting {
    timeout = 10
    retryInterval = 0.5
}

atCheckWaiting = true
baseNavigatorWaiting = true

reportsDir = "build/geb-reports"

baseUrl = "http://127.0.0.1:8000"