package it.unicam.pnm.inbound.adapter.rest.dto.produttore;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProduttoreCreateDTO implements Serializable {

    @NotBlank
    private String nome;

    @NotBlank
    private String cognome;
    
    @NotBlank
    private String codiceFiscale;
    
    @NotBlank
    private String numeroPrivato;

    @NotBlank
    private String email;

    @NotBlank
    private String partitaIva;

    // vediamo se riusciamo a trovargli un nome migliore
    private boolean tesseramentoAttivo;
}
