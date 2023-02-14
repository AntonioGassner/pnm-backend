package it.unicam.pnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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

