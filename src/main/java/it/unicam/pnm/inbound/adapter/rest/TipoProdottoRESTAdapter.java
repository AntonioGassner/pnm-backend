package it.unicam.pnm.inbound.adapter.rest;

import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoUpdateDTO;
import it.unicam.pnm.inbound.port.TipoProdottoInboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

// TODO io.swagger.v3.oas.annotations?

@RestController
@RequestMapping("/api/tipoProdotto")
public class TipoProdottoRESTAdapter {

    @Autowired
    private TipoProdottoInboundPort tipoProdottoInboundPort;

    @PostMapping
    public ResponseEntity<TipoProdottoDTO> createTipoProdotto(@Valid @RequestBody TipoProdottoCreateDTO dto){
        return new ResponseEntity<>(tipoProdottoInboundPort.create(dto), HttpStatus.OK);
    }

    // TODO getByIds?

    @GetMapping("/ricerca")
    public ResponseEntity<Page<TipoProdottoDTO>> searchTipoProdotto(@Valid @RequestBody TipoProdottoCriteria criteria, Pageable pageRequest){
        Page<TipoProdottoDTO> dtos = tipoProdottoInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<TipoProdottoDTO> updateTipoProdotto(@Valid @RequestBody TipoProdottoUpdateDTO dto){
        return new ResponseEntity<>(tipoProdottoInboundPort.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> TipoProdotto(@PathVariable("id") UUID id){
        tipoProdottoInboundPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
