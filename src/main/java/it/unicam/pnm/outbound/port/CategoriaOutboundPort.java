package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.CategoriaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CategoriaOutboundPort {

    CategoriaModel save(CategoriaModel model);

    Page<CategoriaModel> search(CategoriaCriteria criteria, Pageable pageRequest);

    CategoriaModel getById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
