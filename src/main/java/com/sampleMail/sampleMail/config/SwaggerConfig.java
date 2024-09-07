package com.sampleMail.sampleMail.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {


    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Sample mail")
                .description("Sample mail")
                .termsOfServiceUrl("")
                .version("1.0.0").contact(new Contact("sample LTD", "www.xxxxxxxx", "info@.ng")).build();
    }

    @Bean
    public Docket configureControllerPackageAndConvertors() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.sampleMail.sampleMail.controller")).build()
                .apiInfo(apiInfo());
    }


}

