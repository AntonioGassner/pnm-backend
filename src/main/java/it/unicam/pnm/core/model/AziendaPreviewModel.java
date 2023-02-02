package it.unicam.pnm.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaPreviewModel implements Serializable {

    private UUID id;

    private String nomeProduttore;

    private String cognomeProduttore;

    private String nomeAzienda;

    private String comune;

    private String provincia;

    private String indirizzo;

    private String descrizioneBreve;

    private String tipoProdotto;
}
