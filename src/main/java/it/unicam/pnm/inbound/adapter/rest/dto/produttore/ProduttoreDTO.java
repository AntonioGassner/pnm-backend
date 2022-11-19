package it.unicam.pnm.inbound.adapter.rest.dto.produttore;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProduttoreDTO implements Serializable {

    private UUID id;

    private String nome;

    private String cognome;

    private String codiceFiscale;

    private String numeroPrivato;

    private String email;

    private String partitaIva;

    // vediamo se riusciamo a trovargli un nome migliore
    private boolean tesseramentoAttivo;

}
