package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.TipoProdottoModel;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TipoProdottoOutboundPort {

    TipoProdottoModel save(TipoProdottoModel model);

    Page<TipoProdottoModel> search(TipoProdottoCriteria criteria, Pageable pageRequest);

    TipoProdottoModel getById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
