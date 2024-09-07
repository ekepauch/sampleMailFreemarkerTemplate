package com.sampleMail.sampleMail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class CustomWebMvcAutoConfig extends WebMvcConfigurerAdapter {




    @Override
    public void addCorsMappings(CorsRegistry registry) {

             registry.addMapping("/**")
               .allowedOrigins("*")
                .allowedMethods("POST", "GET",  "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(4800);
    }
}
