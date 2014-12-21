package com.github.webuitesting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by amit on 12/20/14.
 */
@Configuration
public class TestConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        String activeProfile = System.getProperty("spring.profiles.active", "prod");
        String propertiesFilename = "app-" + activeProfile + ".properties";

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("config.properties"),
                new ClassPathResource(propertiesFilename));

        return configurer;
    }
}
