package com.fj.swagger.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * swagger ui
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/19 2:12
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 要扫描的API(Controller)基础包
                .apis(RequestHandlerSelectors.basePackage("com.fj"))
                // 要扫描的API(Controller)全局-(就是可以扫描所有的带有api注解的包并生成文档)
                // .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    //配置在线文档的基本信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("肥啾", "http://localhost:10409","1030208759@qq,com");
        return new ApiInfoBuilder()
                .title("API文档")
                .description("肥啾API文档")
                .contact(contact)
                .version("1.0.0")
                .termsOfServiceUrl("http://localhost:10409")
                .license("LICENSE")
                .licenseUrl("http://localhost:10409")
                .build();
    }

}
