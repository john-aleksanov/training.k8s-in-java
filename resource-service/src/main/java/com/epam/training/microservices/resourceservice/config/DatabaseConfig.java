package com.epam.training.microservices.resourceservice.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @Profile("postgres")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url("jdbc:postgresql://resource-db:5432/resource-service")
            .username("pg")
            .password("pg")
            .build();
    }

    @Bean
    @Profile("!postgres")
    public DataSource embeddedDataSource() {
        return DataSourceBuilder.create()
            .driverClassName("org.h2.Driver")
            .url("jdbc:h2:file:~/resource-service")
            .username("h2")
            .password("h2")
            .build();
    }
}
