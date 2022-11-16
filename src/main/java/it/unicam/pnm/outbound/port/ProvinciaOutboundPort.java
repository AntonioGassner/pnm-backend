package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.ProvinciaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProvinciaOutboundPort {

    ProvinciaModel save(ProvinciaModel model);

    Page<ProvinciaModel> search(ProvinciaCriteria criteria, Pageable pageRequest);

    ProvinciaModel getById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
