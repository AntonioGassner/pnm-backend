package it.unicam.pnm.inbound.adapter.rest;

import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoUpdateDTO;
import it.unicam.pnm.inbound.port.ProdottoInboundPort;
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
@RequestMapping("/api/prodotto")
public class ProdottoRESTAdapter {

    @Autowired
    private ProdottoInboundPort prodottoInboundPort;

    @PostMapping
    public ResponseEntity<ProdottoDTO> createProdotto(@Valid @RequestBody ProdottoCreateDTO dto){
        return new ResponseEntity<>(prodottoInboundPort.create(dto), HttpStatus.OK);
    }

    // TODO getByIds?

    @GetMapping("/ricerca")
    public ResponseEntity<Page<ProdottoDTO>> searchProdotto(@Valid @RequestBody ProdottoCriteria criteria, Pageable pageRequest){
        Page<ProdottoDTO> dtos = prodottoInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<ProdottoDTO> updateProdotto(@Valid @RequestBody ProdottoUpdateDTO dto){
        return new ResponseEntity<>(prodottoInboundPort.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Prodotto(@PathVariable("id") UUID id){
        prodottoInboundPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
