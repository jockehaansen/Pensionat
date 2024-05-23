package com.example.pensionat.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan
@Configuration
@ConfigurationProperties(prefix = "integrations")
@Getter
@Setter
public class IntegrationProperties {
    private BlackListProperties blacklist;
}
