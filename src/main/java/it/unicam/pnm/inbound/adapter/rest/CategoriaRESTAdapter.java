package it.unicam.pnm.inbound.adapter.rest;

import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaUpdateDTO;
import it.unicam.pnm.inbound.port.CategoriaInboundPort;
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
@RequestMapping("/api/categoria")
public class CategoriaRESTAdapter {

    @Autowired
    private CategoriaInboundPort categoriaInboundPort;

    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@Valid @RequestBody CategoriaCreateDTO dto) {
        return new ResponseEntity<>(categoriaInboundPort.create(dto), HttpStatus.OK);
    }

    // TODO getByIds?

    @GetMapping("/ricerca")
    public ResponseEntity<Page<CategoriaDTO>> searchCategoria(CategoriaCriteria criteria, Pageable pageRequest) {
        Page<CategoriaDTO> dtos = categoriaInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> updateCategoria(@Valid @RequestBody CategoriaUpdateDTO dto) {
        return new ResponseEntity<>(categoriaInboundPort.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable("id") UUID id) {
        categoriaInboundPort.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
