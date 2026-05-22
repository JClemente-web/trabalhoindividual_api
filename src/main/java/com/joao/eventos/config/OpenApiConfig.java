package com.joao.eventos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Sistema de Eventos Acessíveis")
                        .version("1.0.0")
                        .description("API RESTful desenvolvida para o trabalho prático com Spring Boot e PostgreSQL."));
    }
}