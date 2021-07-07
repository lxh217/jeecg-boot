package com.kt.plus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//忽略前端请求时丢失的请求头
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")

                .allowedOrigins("*")

                .allowCredentials(true)

                .allowedMethods("GET", "POST", "DELETE", "PUT")

                .maxAge(3600);

    }

}
