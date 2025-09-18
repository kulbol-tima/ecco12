package kg.mlsp.ubk.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class UbkSwaggerConfig {

    @Bean
    public GroupedOpenApi ubkApi() {
        return GroupedOpenApi.builder()
                .group("Ubk")
                .packagesToScan("kg.mlsp.ubk.controller")
                .build();
    }

    @Bean
    @Primary
    public OpenAPI ubkOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ESSO UBK Module")
                        .version("0.0.1")
                        .description("Integration with ESSO UBK module"));
    }
}