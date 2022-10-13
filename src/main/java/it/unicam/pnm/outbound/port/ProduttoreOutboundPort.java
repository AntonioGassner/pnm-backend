package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.ProduttoreModel;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProduttoreOutboundPort {

    ProduttoreModel save(ProduttoreModel model);

    Page<ProduttoreModel> search(ProduttoreCriteria criteria, Pageable pageRequest);

    ProduttoreModel getById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
