package it.unicam.pnm.inbound.adapter.rest.dto.categoria;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CategoriaDTO implements Serializable {

    private UUID id;

    private String nome;

    private String descrizione;
}
