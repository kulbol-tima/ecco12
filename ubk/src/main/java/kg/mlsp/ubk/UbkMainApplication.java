package kg.mlsp.ubk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "kg.mlsp.ubk",
                "kg.mlsp.common",
                "kg.mlsp.integration",
        },
        exclude = {
                org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
        }
)
public class UbkMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(UbkMainApplication.class, args);
    }
}