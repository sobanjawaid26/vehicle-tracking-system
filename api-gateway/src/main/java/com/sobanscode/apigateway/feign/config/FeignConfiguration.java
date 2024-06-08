package com.sobanscode.apigateway.feign.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

//Since I could not run Api Gateway with Spring 3, I used Spring 2.7.14, so I had to define such a bean in this version of Feign.
@Configuration
public class FeignConfiguration {

    @Bean
    public HttpMessageConverters customHttpMessageConverters() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();

        return new HttpMessageConverters(jsonConverter);
    }
}
