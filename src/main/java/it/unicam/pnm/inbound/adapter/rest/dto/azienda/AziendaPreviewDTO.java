package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaPreviewDTO implements Serializable {

    private UUID id;

    private String nomeProduttore;

    private String cognomeProduttore;

    private String nomeAzienda;

    private String comune;

    private String provincia;

    private String indirizzo;

    private String cap;

    private String descrizioneBreve;

    private String tipoProdotto;
}
