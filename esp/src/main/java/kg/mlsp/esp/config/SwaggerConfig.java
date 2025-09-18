package kg.mlsp.esp.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    private final BuildProperties buildProperties;

    @Autowired
    public SwaggerConfig(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }


    @Bean
    public OpenAPI uosOpenAPI() {

        Info info = new Info()
                .title("ESSO ESP Module")
                .version(buildProperties.getVersion())
                .description("This module provides integration with the ESSO system for ESP.");
        return new OpenAPI().info(info);
    }

}