package com.epam.training.microservices.songservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${PG_USER}")
    private String dbUser;

    @Value("${PG_PASSWORD}")
    private String dbPassword;

    @Bean
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url("jdbc:postgresql://song-db:5432/postgres")
            .username(dbUser)
            .password(dbPassword)
            .build();
    }
}
