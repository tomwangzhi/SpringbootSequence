package com.intellif.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.primary")
@Data
public class PrimaryDataSourceProperty {

    private String url;
    private String password;
    private String username;
    private String driveClass;
    private int maxPoolSize;
    private int initPoolSize;
}
