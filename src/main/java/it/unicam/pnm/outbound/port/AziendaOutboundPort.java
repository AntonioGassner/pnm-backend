package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AziendaOutboundPort {

    AziendaModel save(AziendaModel model);

    Page<AziendaModel> search(AziendaCriteria criteria, Pageable pageRequest);

    AziendaModel getById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
