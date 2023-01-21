package it.unicam.pnm.inbound.port;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.UUID;

public interface AziendaInboundPort {

    AziendaDTO create(AziendaCreateDTO dto);

    Page<AziendaPreviewDTO> searchPreview(AziendaCriteria criteria, Pageable pageRequest);

    AziendaDTO getByUUID(UUID id);

    AziendaDettaglioDTO getDettaglioByUUID(UUID id);

    ArrayList<String> getMailingList();

    void toggleTesseramento(UUID id);

    Page<AziendaDTO> search(AziendaCriteria criteria, Pageable pageRequest);

    AziendaDTO update(AziendaUpdateDTO dto);

    void delete(UUID id);
}
