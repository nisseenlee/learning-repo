package com.mycompany.propertymanagement.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public GroupedOpenApi appApi() {
        return GroupedOpenApi.builder()
                .group("appApi")
                .pathsToMatch("/**")
                .build();
    }
}
