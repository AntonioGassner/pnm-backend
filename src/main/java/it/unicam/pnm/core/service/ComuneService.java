package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.ComuneDTOMapper;
import it.unicam.pnm.core.model.ComuneModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneUpdateDTO;
import it.unicam.pnm.inbound.port.ComuneInboundPort;
import it.unicam.pnm.outbound.port.ComuneOutboundPort;
import it.unicam.pnm.outbound.port.ProvinciaOutboundPort;
import it.unicam.pnm.web.rest.errors.BadRequestException;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ComuneService implements ComuneInboundPort {

    @Autowired
    private ComuneDTOMapper comuneMapper;

    @Autowired
    private ComuneOutboundPort comunePersistence;

    @Autowired
    private ProvinciaOutboundPort provinciaPersistence;

    @Override
    public ComuneDTO create(ComuneCreateDTO dto) {
        ComuneDTO comuneDto = comuneMapper.fromCreateDTO(dto);
        this.validate(comuneDto);
        return comuneMapper.toDto(comunePersistence.save(comuneMapper.toModel(comuneDto)));
    }

    @Override
    public Page<ComuneDTO> search(ComuneCriteria criteria, Pageable pageRequest) {
        Page<ComuneModel> models = comunePersistence.search(criteria, pageRequest);
        return models.map(model -> this.comuneMapper.toDto(model));
    }

    @Override
    public ComuneDTO update(ComuneUpdateDTO dto) {
        this.checkExists(dto.getId());
        ComuneDTO comuneDto = comuneMapper.fromUpdateDTO(dto);
        this.validate(comuneDto);
        return comuneMapper.toDto(comunePersistence.save(comuneMapper.toModel(comuneDto)));
    }

    @Override
    public void delete(UUID id) {
        this.checkExists(id);
        comunePersistence.delete(id);
    }

    private void checkExists(UUID id) {
        if (!comunePersistence.existsById(id)) {
            throw new NotFoundException(String.format("Comune %s non trovato", id));
        }
    }

    private void validate(ComuneDTO dto){

        boolean error = false;
        String error_validate = "";

        if (!provinciaPersistence.existsById(dto.getProvincia().getId())) {
            error = true;
            error_validate += "Provincia";
        }

        if (error) {
            // TODO logging
            //log.warn("DomandaDieta error: {}", error_validate);
            throw new BadRequestException(String.format("Errore creazione Comune : %s non trovato", error_validate));
        }
    }

}
