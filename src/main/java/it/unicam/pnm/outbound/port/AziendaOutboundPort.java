package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AziendaOutboundPort {

    AziendaModel save(AziendaModel model);

    Page<AziendaModel> search(AziendaCriteria criteria, Pageable pageRequest);

    List<AziendaModel> findByIds(List<UUID> ids);

    AziendaModel validateLogin(String user, String pass);

    boolean existsById(UUID id);

    void setTesseramentoAttivo(UUID id);

    void delete(UUID id);
}
