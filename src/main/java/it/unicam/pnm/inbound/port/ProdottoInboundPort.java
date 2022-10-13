package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProdottoInboundPort {

    ProdottoDTO create(ProdottoCreateDTO dto);

    Page<ProdottoDTO> search(ProdottoCriteria criteria, Pageable pageRequest);

    ProdottoDTO update(ProdottoUpdateDTO dto);

    void delete(UUID id);

}
