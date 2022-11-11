package it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class TipoProdottoDTO implements Serializable {

    private UUID id;

    private String nome;

    private String descrizione;
}
