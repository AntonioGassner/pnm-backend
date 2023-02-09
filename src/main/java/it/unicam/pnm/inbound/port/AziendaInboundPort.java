package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AziendaInboundPort {

    AziendaDTO create(AziendaCreateDTO dto);

    List<AziendaDTO> findByIds(List<UUID> ids);

    Page<AziendaDTO> search(AziendaCriteria criteria, Pageable pageRequest);

    AziendaDTO validateLogin(String user, String pass);

    AziendaDTO update(AziendaUpdateDTO dto);

    void setTesseramentoAttivo(UUID id);

    void delete(UUID id);
}
