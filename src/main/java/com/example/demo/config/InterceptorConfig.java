package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**").addPathPatterns("/attendant/**"); super.addInterceptors(registry);
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/checkemail").addPathPatterns("/checktel")
                .addPathPatterns(new String[]{"/checktel", "/logout","/deleteComment","/saveComment","/addCollection","/checkCollection","/deleteCollection"}); super.addInterceptors(registry);
        registry.addInterceptor(new IPcheckInterceptor()).addPathPatterns("/**"); super.addInterceptors(registry);
    }
}
