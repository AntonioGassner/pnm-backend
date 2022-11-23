package it.unicam.pnm.inbound.adapter.rest;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaUpdateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaUpdateDTO;
import it.unicam.pnm.inbound.port.AziendaCategoriaInboundPort;
import it.unicam.pnm.inbound.port.AziendaInboundPort;
import it.unicam.pnm.outbound.port.AziendaCategoriaOutboundPort;
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
    private AziendaCategoriaInboundPort aziendaCategoriaInboundPort;

    @PostMapping
    public ResponseEntity<AziendaCategoriaDTO> createAziendaCategoria(@Valid @RequestBody AziendaCategoriaCreateDTO dto) {
        return new ResponseEntity<>(aziendaCategoriaInboundPort.create(dto), HttpStatus.OK);
    }

    // TODO getByIds?

    @GetMapping("/ricerca")
    public ResponseEntity<Page<AziendaCategoriaDTO>> searchAziendaCategoria(AziendaCategoriaCriteria criteria, Pageable pageRequest) {
        Page<AziendaCategoriaDTO> dtos = aziendaCategoriaInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<AziendaCategoriaDTO> updateAziendaCategoria(@Valid @RequestBody AziendaCategoriaUpdateDTO dto) {
        return new ResponseEntity<>(aziendaCategoriaInboundPort.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAziendaCategoria(@PathVariable("id") UUID id) {
        aziendaCategoriaInboundPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
