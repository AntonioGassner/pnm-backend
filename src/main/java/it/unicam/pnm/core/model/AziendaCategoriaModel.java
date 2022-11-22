package it.unicam.pnm.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaCategoriaModel implements Serializable {

    private UUID id;

    private AziendaModel azienda;

    private CategoriaModel categoria;
}
