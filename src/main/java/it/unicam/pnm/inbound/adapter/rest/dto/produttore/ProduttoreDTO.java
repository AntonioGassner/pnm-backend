package it.unicam.pnm.inbound.adapter.rest.dto.produttore;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProduttoreDTO implements Serializable {

    private UUID id;

    private String nome;

    private String cognome;
}
