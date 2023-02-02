package it.unicam.pnm.outbound.port;

import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.UUID;

public interface AziendaOutboundPort {

    AziendaModel save(AziendaModel model);

    Page<AziendaModel> searchPreview(AziendaCriteria criteria, Pageable pageRequest);

    Page<AziendaModel> search(AziendaCriteria criteria, Pageable pageRequest);

    AziendaModel getById(UUID id);

    AziendaModel getDettaglioById(UUID id);

    Page<AziendaModel> getContactList();

    boolean validateLogin(String user, String pass);

    boolean existsById(UUID id);

    void attivaTesseramento(UUID id);

    void delete(UUID id);
}
