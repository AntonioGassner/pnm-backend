package it.unicam.pnm.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProduttoreModel implements Serializable {

    private UUID id;

    private String nome;

    private String cognome;

    private String codiceFiscale;

    private String numeroPrivato;

    private String email;

    private String partitaIva;

    private boolean tesseramentoAttivo;

}
