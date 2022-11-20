package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TipoProdottoInboundPort {

    TipoProdottoDTO create(TipoProdottoCreateDTO dto);

    Page<TipoProdottoDTO> search(TipoProdottoCriteria criteria, Pageable pageRequest);

    TipoProdottoDTO update(TipoProdottoUpdateDTO dto);

    void delete(UUID id);

}
