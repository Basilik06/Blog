package com.crud.demo.config;

import com.crud.demo.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class FilterConfig {

    @Autowired
    private JwtRequestFilter jwtFilter;

    @Bean
    public FilterRegistrationBean<JwtRequestFilter> jwtFilterRegistration() {
        FilterRegistrationBean<JwtRequestFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(jwtFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
