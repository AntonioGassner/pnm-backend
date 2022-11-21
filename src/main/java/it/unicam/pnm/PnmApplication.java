package it.unicam.pnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO security layer

// TODO session tokens

// TODO logging system

// TODO admin view/flow to publish changes ?

// TODO encripted db?

// TODO mailing list?

// TODO how to handle delete of db entries

// TODO mail notifications when someone registers and is waiting for approval

// TODO validation for foreign keys when adding entries at Service layer

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PnmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PnmApplication.class, args);
    }

}
