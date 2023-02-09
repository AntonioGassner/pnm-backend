package it.unicam.pnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// TODO security layer

// TODO session tokens

// TODO logging system

// TODO admin view/flow to publish changes ?

// TODO encripted db?

// TODO mailing list?

// TODO mail notifications when someone registers and is waiting for approval


@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class PnmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PnmApplication.class, args);
    }

}

