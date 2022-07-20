package com.al_tair.storage.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @author Al_tair
 * @date 2022/7/20-11:12
 */
//@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI lnsFileOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("网盘项目 API")
                        .description("Web文件系统，旨在为用户提供一个简单、方便的文件存储方案，能够以完善的目录结构体系，对文件进行管理")
                        .version("version 1.0")
                        .license(new License().name("MIT").url("http://springdoc.org")));
    }
}
