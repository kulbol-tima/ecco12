package kg.mlsp.esp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("kg.mlsp.esp.model")
public class EspMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(EspMainApplication.class, args);
    }

}
