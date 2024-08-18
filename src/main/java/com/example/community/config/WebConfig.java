package com.example.community.config;

import com.example.community.com.MenuInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MenuInterceptor menuInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(menuInterceptor)
//                .addPathPatterns("/**");
    }
}
