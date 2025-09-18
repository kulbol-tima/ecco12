package kg.mlsp.integration.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class IntegrationSwaggerConfig {

    @Bean
    public GroupedOpenApi integrationApi() {
        return GroupedOpenApi.builder()
                .group("Integration")
                .packagesToScan("kg.mlsp.integration.controller")
                .build();
    }

    @Bean
    @ConditionalOnMissingBean(OpenAPI.class)
    public OpenAPI integrationOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ESSO Integration Module")
                        .version("0.0.1")
                        .description("Integration with ESSO Integration module"));
    }
}