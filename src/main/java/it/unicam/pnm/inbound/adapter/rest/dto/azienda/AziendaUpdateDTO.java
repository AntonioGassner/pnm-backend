package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaUpdateDTO implements Serializable {

    private UUID id;

    private String nomeProduttore;

    private String cognomeProduttore;

    private String partitaIva;

    private String numeroPrivato;

    private String emailPrivata;

    private String codiceFiscale;

    private boolean tesseramentoAttivo;

    private String nomeAzienda;

    private String ragioneSociale;

    private String numeroAzienda;

    private String emailAzienda;

    private String comune;

    private String provincia;

    private String indirizzo;

    private String cap;

    private String descrizioneBreve;

    private String descrizioneLunga;

    private String linkFacebook;

    private String linkYoutube;

    private String linkInstagram;

    private String linkWebsite;

    private String linkTicToc;

    private String tipoProdotto;

    private String password;
}
