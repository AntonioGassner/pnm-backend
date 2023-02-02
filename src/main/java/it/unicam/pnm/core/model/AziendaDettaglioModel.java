package it.unicam.pnm.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaDettaglioModel implements Serializable {

    private UUID id;

    private String nomeProduttore;

    private String cognomeProduttore;

    private String partitaIva;

    private String nomeAzienda;

    private String numeroAzienda;

    private String emailAzienda;

    private String comune;

    private String provincia;

    private String indirizzo;

    private String cap;

    private String descrizioneLunga;

    private String linkFacebook;

    private String linkYoutube;

    private String linkInstagram;

    private String linkWebsite;

    private String linkTicToc;

    private String tipoProdotto;
}
