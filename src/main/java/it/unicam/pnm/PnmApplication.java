package it.unicam.pnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO delete is not mapped or something
//  Resolved [org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'DELETE' not supported]

// TODO search doesen't pass over criteria or something since every field i put in i always get all results

// TODO security layer

// TODO session tokens

// TODO logging system

// TODO admin view/flow to publish changes ?

// TODO encripted db?

// TODO mailing list?

// TODO how to handle delete of db entries

// TODO mail notifications when someone registers and is waiting for approval

// TODO validation for foreign keys when adding entries at Service layer

//TODO sistemare la faccenda foreign keys con le annotations
// non sono sicuro che serve perché possiamo sempre cercare le entry che ci interessano usando il relativo UUID

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PnmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PnmApplication.class, args);
    }

}
