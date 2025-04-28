package com.sportslounge.move.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local", "development"})
public class SwaggerConfig {
    @Bean
    @Profile("development")
    public OpenAPI devOpenAPI () {
        return new OpenAPI().addServersItem(new Server().url("https://slbe-454806.appspot.com").description("개발기"));
    }

    @Bean
    @Profile("local")
    public OpenAPI localOpenAPI () {
        return new OpenAPI().addServersItem(new Server().url("http://localhost:8080").description("로컬.."));
    }
}
