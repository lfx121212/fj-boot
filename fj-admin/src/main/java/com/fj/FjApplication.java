package com.fj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <p>
 * 项目启动类
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/18 22:22
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class FjApplication {
    public static void main(String[] args) {
        System.setProperty("appName", FjApplication.class.getSimpleName());
        SpringApplication.run(FjApplication.class);
    }
}
