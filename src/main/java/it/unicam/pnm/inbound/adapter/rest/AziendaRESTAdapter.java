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
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/azienda")
public class AziendaRESTAdapter {

    @Autowired
    private AziendaInboundPort aziendaInboundPort;

//    @Operation(summary = "Crea un'Azienda", description = "La creazione richiede: nomeProduttore, cognomeProduttore, partitaIva, numeroPrivato, emailPrivata, codiceFiscale, nomeAzienda, ragioneSociale, numeroAzienda, emailAzienda, comune, provincia, indirizzo, cap, password", tags = {"Anagrafica Resource"})
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Azienda creata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
    @PostMapping
    public ResponseEntity<AziendaDTO> createAzienda(@Valid @RequestBody AziendaCreateDTO dto) {
        return new ResponseEntity<>(aziendaInboundPort.create(dto), HttpStatus.OK);
    }

    @GetMapping(params = {"ids"})
    public ResponseEntity<List<AziendaDTO>> findAziendaByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        List<AziendaDTO> dtos = aziendaInboundPort.findByIds(ids);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @GetMapping("/ricerca")
    public ResponseEntity<Page<AziendaDTO>> searchAzienda(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaDTO> dtos = aziendaInboundPort.search(criteria, pageRequest);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @GetMapping("/login")
    ResponseEntity<AziendaDTO> validateLogin(String user, String pass) {
        return new ResponseEntity<>(aziendaInboundPort.validateLogin(user, pass), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> attivaTesseramento(@PathVariable("id") UUID id) {
        aziendaInboundPort.setTesseramentoAttivo(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
