package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.ComuneModel;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ComuneOutboundPort {

    ComuneModel save(ComuneModel model);

    Page<ComuneModel> search(ComuneCriteria criteria, Pageable pageRequest);

    ComuneModel getById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
