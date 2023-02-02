package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.AziendaDTOMapper;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.*;
import it.unicam.pnm.inbound.port.AziendaInboundPort;
import it.unicam.pnm.outbound.port.AziendaOutboundPort;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
// @Slf4j logging TODO
public class AziendaService implements AziendaInboundPort {

    @Autowired
    private AziendaDTOMapper aziendaMapper;

    @Autowired
    private AziendaOutboundPort aziendaPersistence;

//    @Autowired
//    private ProvinciaOutboundPort provinciaPersistence;
//
//    @Autowired
//    private ComuneOutboundPort comunePersistence;

    @Override
    public AziendaDTO create(AziendaCreateDTO dto) {
        AziendaDTO aziendaDto = aziendaMapper.fromCreateDTO(dto);
        //this.validate(aziendaDto);
        return aziendaMapper.toDto(aziendaPersistence.save(aziendaMapper.toModel(aziendaDto)));
    }

    @Override
    public Page<AziendaDTO> searchPreview(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaModel> models = aziendaPersistence.searchPreview(criteria, pageRequest);
        return models.map(model -> this.aziendaMapper.toDto(model));
    }

    @Override
    public Page<AziendaDTO> search(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaModel> models = aziendaPersistence.search(criteria, pageRequest);
        return models.map(model -> this.aziendaMapper.toDto(model));
    }

    @Override
    public AziendaDTO getById(UUID id) {
        return this.aziendaMapper.toDto(aziendaPersistence.getById(id));
    }

    @Override
    public AziendaDTO getDettaglioById(UUID id) {
        return this.aziendaMapper.toDto(aziendaPersistence.getDettaglioById(id));
    }

    @Override
    public Page<AziendaModel> getContactList() {
        return aziendaPersistence.getContactList();
    }

    @Override
    public boolean validateLogin(String user, String pass){
        return this.aziendaPersistence.validateLogin(user, pass);
    }

    @Override
    public AziendaDTO update(AziendaUpdateDTO dto) {
        this.checkExists(dto.getId());
        AziendaDTO aziendaDto = aziendaMapper.fromUpdateDTO(dto);
        //this.validate(aziendaDto);
        return aziendaMapper.toDto(aziendaPersistence.save(aziendaMapper.toModel(aziendaDto)));
    }

    @Override
    public void attivaTesseramento(UUID id) {
        this.checkExists(id);
        aziendaPersistence.attivaTesseramento(id);
    }

    @Override
    public void delete(UUID id) {
        this.checkExists(id);
        aziendaPersistence.delete(id);
    }

    private void checkExists(UUID id) {
        if (!aziendaPersistence.existsById(id)) {
            throw new NotFoundException(String.format("Azienda %s non trovato", id));
        }
    }

//    private void validate(AziendaDTO dto){
//
//        boolean error = false;
//        String error_validate = "";
//
//        if (!comunePersistence.existsById(dto.getComune().getId())) {
//            error = true;
//            error_validate += "Comune";
//        }
//
//        if (!provinciaPersistence.existsById(dto.getProvincia().getId())) {
//            if (!error_validate.equals(""))
//                error_validate += ", ";
//            error = true;
//            error_validate += "Provincia";
//        }
//
//        if (error) {
//            //log.warn("DomandaDieta error: {}", error_validate);
//            throw new BadRequestException(String.format("Errore creazione Azienda : %s non trovato", error_validate));
//        }
//    }

}
