package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProduttoreInboundPort {

    ProduttoreDTO create(ProduttoreCreateDTO dto);

    Page<ProduttoreDTO> search(ProduttoreCriteria criteria, Pageable pageRequest);

    ProduttoreDTO update(ProduttoreUpdateDTO dto);

    void delete(UUID id);
}
