package kg.mlsp.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "kg.mlsp.common",
                "kg.mlsp.integration",
        },
        exclude = {
                org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
        }
)
public class CommonMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonMainApplication.class, args);
    }

}
