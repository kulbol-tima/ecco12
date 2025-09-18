package kg.mlsp.common.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CommonSwaggerConfig {

    @Bean
    public GroupedOpenApi commonApi() {
        return GroupedOpenApi.builder()
                .group("Common")
                .packagesToScan("kg.mlsp.common.controller")
                .build();
    }

    @Bean
    public OpenAPI commonOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ESSO Common Module")
                        .version("0.0.1")
                        .description("Integration with ESSO Common module"));
    }
}