package it.unicam.pnm.inbound.adapter.rest;

import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneUpdateDTO;
import it.unicam.pnm.inbound.port.ComuneInboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/comune")
public class ComuneRESTAdapter {

    @Autowired
    private ComuneInboundPort comuneInboundPort;

    @PostMapping
    public ResponseEntity<ComuneDTO> createComune(@Valid @RequestBody ComuneCreateDTO dto) {
        return new ResponseEntity<>(comuneInboundPort.create(dto), HttpStatus.OK);
    }

    // TODO getByIds?

    @GetMapping("/ricerca")
    public ResponseEntity<Page<ComuneDTO>> searchComune(ComuneCriteria criteria, Pageable pageRequest) {
        Page<ComuneDTO> dtos = comuneInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<ComuneDTO> updateComune(@Valid @RequestBody ComuneUpdateDTO dto) {
        return new ResponseEntity<>(comuneInboundPort.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComune(@PathVariable("id") UUID id) {
        comuneInboundPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
