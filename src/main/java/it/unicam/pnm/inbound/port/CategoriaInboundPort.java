package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CategoriaInboundPort {

    CategoriaDTO create(CategoriaCreateDTO dto);

    Page<CategoriaDTO> search(CategoriaCriteria criteria, Pageable pageRequest);

    CategoriaDTO update(CategoriaUpdateDTO dto);

    void delete(UUID id);

}
