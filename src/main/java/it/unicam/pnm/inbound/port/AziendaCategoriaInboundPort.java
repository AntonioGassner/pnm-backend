package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AziendaCategoriaInboundPort {

    AziendaCategoriaDTO create(AziendaCategoriaCreateDTO dto);

    Page<AziendaCategoriaDTO> search(AziendaCategoriaCriteria criteria, Pageable pageRequest);

    AziendaCategoriaDTO update(AziendaCategoriaUpdateDTO dto);

    void delete(UUID id);
}
