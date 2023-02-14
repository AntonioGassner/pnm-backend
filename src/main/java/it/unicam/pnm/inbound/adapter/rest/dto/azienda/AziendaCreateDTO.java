package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class AziendaCreateDTO implements Serializable {

    @NotBlank
    private String nomeProduttore;

    @NotBlank
    private String cognomeProduttore;

    @Size(min = 11, max = 11)
    @NotBlank
    private String partitaIva;

    @NotBlank
    private String numeroPrivato;

    @Email
    @NotBlank
    private String emailPrivata;

    @Size(min = 16, max = 16)
    @NotBlank
    private String codiceFiscale;

    @NotBlank
    private String nomeAzienda;

    @NotBlank
    private String ragioneSociale;

    @NotBlank
    private String numeroAzienda;

    @Email
    @NotBlank
    private String emailAzienda;

    @NotBlank
    private String comune;

    @NotBlank
    private String provincia;

    @NotBlank
    private String indirizzo;

    @NotBlank
    private String cap;

    @Size(min = 8)
    @NotBlank
    private String password;
}
