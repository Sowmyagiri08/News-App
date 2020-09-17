package com.natwest.gatewayservice.config;

import com.natwest.gatewayservice.filter.JWTValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JWTValidationFilter());
        filterRegistrationBean.addUrlPatterns("/favourite-service/api/v1/*");
        return filterRegistrationBean;
    }
}
