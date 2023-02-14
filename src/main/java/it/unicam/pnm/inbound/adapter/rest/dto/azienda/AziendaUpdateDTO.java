package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaUpdateDTO implements Serializable {

    private UUID id;

    @NotBlank
    private String nomeProduttore;

    @NotBlank
    private String cognomeProduttore;

    @NotBlank
    @Size(min = 11, max = 11)
    private String partitaIva;

    @NotBlank
    private String numeroPrivato;

    @Email
    @NotBlank
    private String emailPrivata;

    @Size(min = 16, max = 16)
    @NotBlank
    private String codiceFiscale;

    private boolean tesseramentoAttivo;

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

    @Size(max = 200)
    private String descrizioneBreve;

    @Size(max = 2000)
    private String descrizioneLunga;

    private String linkFacebook;

    private String linkYoutube;

    private String linkInstagram;

    private String linkWebsite;

    private String linkTicToc;

    private String tipoProdotto;

    @Size(min = 8)
    @NotBlank
    private String password;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;
}
