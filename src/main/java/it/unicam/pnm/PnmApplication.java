package it.unicam.pnm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class PnmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PnmApplication.class, args);
    }

}
