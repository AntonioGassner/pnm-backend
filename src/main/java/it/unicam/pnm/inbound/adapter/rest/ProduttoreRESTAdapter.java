package it.unicam.pnm.inbound.adapter.rest;

import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreUpdateDTO;
import it.unicam.pnm.inbound.port.ProduttoreInboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/produttore")
public class ProduttoreRESTAdapter {

    @Autowired
    private ProduttoreInboundPort produttoreInboundPort;

    @PostMapping
    public ResponseEntity<ProduttoreDTO> createProduttore(@Valid @RequestBody ProduttoreCreateDTO dto){
        return new ResponseEntity<>(produttoreInboundPort.create(dto), HttpStatus.OK);
    }

    // TODO getByIds?

    @GetMapping("/ricerca")
    public ResponseEntity<Page<ProduttoreDTO>> searchProduttore(@Valid @RequestBody ProduttoreCriteria criteria, Pageable pageRequest){
        Page<ProduttoreDTO> dtos = produttoreInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<ProduttoreDTO> updateProduttore(@Valid @RequestBody ProduttoreUpdateDTO dto){
        return new ResponseEntity<>(produttoreInboundPort.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Produttore(@PathVariable("id") UUID id){
        produttoreInboundPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
