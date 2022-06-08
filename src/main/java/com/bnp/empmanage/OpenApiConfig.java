package com.bnp.empmanage;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Employee Management API")
                        .description("This is a document of Employee Management Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
                        .termsOfService("terms")
                        .contact(new Contact().email("empmanagement@bnpparibas.com"))
                        .license(new License().name("GNU"))
                        .version("1.0")
                );
    }
}
