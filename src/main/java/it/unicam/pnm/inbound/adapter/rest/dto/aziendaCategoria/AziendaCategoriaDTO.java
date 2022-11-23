package it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class AziendaCategoriaDTO implements Serializable {

    private AziendaDTO azienda;

    private CategoriaDTO categoria;
}
