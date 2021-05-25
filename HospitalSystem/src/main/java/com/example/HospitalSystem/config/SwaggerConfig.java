package com.example.HospitalSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.HospitalSystem.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());

    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Hospital System",
                "Application for Hospital Management System",
                "1",
                "Terms of service",
                new Contact("Zhomartkhan Kalanuly", "https://kalanuly.zhomartkhan@gmail.com",
                        "kalanuly.zhomartkhan@gmail.com").toString(),
                "(C) Copyright Zhomartkhan Kalanuly",
                "https://www.copyright.org");
        return apiInfo;
    }
}
