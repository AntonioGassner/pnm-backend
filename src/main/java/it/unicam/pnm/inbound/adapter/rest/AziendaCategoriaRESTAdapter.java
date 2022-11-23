package it.unicam.pnm.inbound.adapter.rest;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaUpdateDTO;
import it.unicam.pnm.inbound.port.AziendaInboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/azienda-categoria")
public class AziendaCategoriaRESTAdapter {

    @Autowired
    private AziendaInboundPort aziendaInboundPort;

    @PostMapping
    public ResponseEntity<AziendaDTO> createAzienda(@Valid @RequestBody AziendaCreateDTO dto) {
        return new ResponseEntity<>(aziendaInboundPort.create(dto), HttpStatus.OK);
    }

    // TODO getByIds?

    @GetMapping("/ricerca")
    public ResponseEntity<Page<AziendaDTO>> searchAzienda(@Valid @RequestBody AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaDTO> dtos = aziendaInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<AziendaDTO> updateAzienda(@Valid @RequestBody AziendaUpdateDTO dto) {
        return new ResponseEntity<>(aziendaInboundPort.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAzienda(@PathVariable("id") UUID id) {
        aziendaInboundPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
