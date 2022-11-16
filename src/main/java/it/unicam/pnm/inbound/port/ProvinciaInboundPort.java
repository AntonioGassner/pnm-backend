package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProvinciaInboundPort {

    ProvinciaDTO create(ProvinciaCreateDTO dto);

    Page<ProvinciaDTO> search(ProvinciaCriteria criteria, Pageable pageRequest);

    ProvinciaDTO update(ProvinciaUpdateDTO dto);

    void delete(UUID id);
}
