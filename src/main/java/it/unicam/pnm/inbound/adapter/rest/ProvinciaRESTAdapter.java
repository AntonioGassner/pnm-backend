package it.unicam.pnm.inbound.adapter.rest;

import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaUpdateDTO;
import it.unicam.pnm.inbound.port.ProvinciaInboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaRESTAdapter {

    @Autowired
    private ProvinciaInboundPort provinciaInboundPort;

    @PostMapping
    public ResponseEntity<ProvinciaDTO> createProvincia(@Valid @RequestBody ProvinciaCreateDTO dto) {
        return new ResponseEntity<>(provinciaInboundPort.create(dto), HttpStatus.OK);
    }

    // TODO getByIds?

    @GetMapping("/ricerca")
    public ResponseEntity<Page<ProvinciaDTO>> searchProvincia(ProvinciaCriteria criteria, Pageable pageRequest) {
        Page<ProvinciaDTO> dtos = provinciaInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<ProvinciaDTO> updateProvincia(@Valid @RequestBody ProvinciaUpdateDTO dto) {
        return new ResponseEntity<>(provinciaInboundPort.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProvincia(@PathVariable("id") UUID id) {
        provinciaInboundPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
