package com.fj;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>
 * 肥啾启动类 Web容器
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/18 22:27
 */
public class FJServletInitializer extends SpringBootServletInitializer {

    //在容器中启动项目

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FjApplication.class);
    }
}
