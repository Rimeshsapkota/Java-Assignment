package com.example.practice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

    @Bean
    public OpenAPI customopenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rest API")
                        .description("Your API Description")
                        .version("1.0")
                        .termsOfService("")
                        .contact(new Contact().name("rest api").url("rest api"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
