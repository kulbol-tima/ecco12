package kg.mlsp.integration.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationClientConfig {

    @Value("${integration-api.x-api-key}")
    protected String xApiKey;

    @Value("${integration-api.user-name}")
    private String userName;

    @Value("${integration-api.role-name}")
    private String roleName;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("x-api-key", xApiKey);
            requestTemplate.query("userName", userName);
            requestTemplate.query("roleName", roleName);
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new IntegrationFeignErrorDecoder();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
