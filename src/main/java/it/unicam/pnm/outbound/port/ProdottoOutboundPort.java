package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.ProdottoModel;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProdottoOutboundPort {

    ProdottoModel save(ProdottoModel model);

    Page<ProdottoModel> search(ProdottoCriteria criteria, Pageable pageRequest);

    ProdottoModel getById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
