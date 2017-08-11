package com.github.webuitesting;

import com.codeborne.selenide.Configuration;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    protected static Config config;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public static void setupEnvironmentConfig() {
        Config baseConfig = ConfigFactory.load("application");//Explicitly named, default is also application.conf
        String env = baseConfig.getString("environment");
        if (env == null ) {
            throw new IllegalArgumentException("Please specify an environment. Valid values are local,test,prod");
        }
        if ( config == null ||  ! config.isResolved() ) {
            config = ConfigFactory.load(env).withFallback(baseConfig);
        }

        Configuration.timeout = 3000;
        Configuration.browser =  config.getString("browser.name");
    }

}
