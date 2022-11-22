package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.AziendaCategoriaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AziendaCategoriaOutboundPort {

    AziendaCategoriaModel save(AziendaCategoriaModel model);

    Page<AziendaCategoriaModel> search(AziendaCategoriaCriteria criteria, Pageable pageRequest);

    AziendaCategoriaModel getById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
