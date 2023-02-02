package it.unicam.pnm.inbound.port;

import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.UUID;

public interface AziendaInboundPort {

    AziendaDTO create(AziendaCreateDTO dto);

    Page<AziendaDTO> searchPreview(AziendaCriteria criteria, Pageable pageRequest);

    Page<AziendaDTO> search(AziendaCriteria criteria, Pageable pageRequest);

    AziendaDTO getById(UUID id);

    AziendaDTO getDettaglioById(UUID id);

    Page<AziendaModel> getContactList();

    boolean validateLogin(String user, String pass);

    AziendaDTO update(AziendaUpdateDTO dto);

    void attivaTesseramento(UUID id);

    void delete(UUID id);
}
