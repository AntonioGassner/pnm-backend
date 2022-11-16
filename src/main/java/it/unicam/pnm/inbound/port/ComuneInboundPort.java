package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ComuneInboundPort {

    ComuneDTO create(ComuneCreateDTO dto);

    Page<ComuneDTO> search(ComuneCriteria criteria, Pageable pageRequest);

    ComuneDTO update(ComuneUpdateDTO dto);

    void delete(UUID id);
}
