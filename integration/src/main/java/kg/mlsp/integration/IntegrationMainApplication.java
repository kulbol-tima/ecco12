package kg.mlsp.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "kg.mlsp.integration.service")
@SpringBootApplication
public class IntegrationMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntegrationMainApplication.class, args);
    }
}
