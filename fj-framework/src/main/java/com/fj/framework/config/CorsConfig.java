package com.fj.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * 跨域
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/19 2:21
 */
@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/api/**")
                //放行原始域(头部信息)
                .allowedHeaders("*")
                //放行原始域(请求方式)
                .allowedMethods("POST", "GET")
                //放行原始域
                .allowedOrigins("*");
    }
}
