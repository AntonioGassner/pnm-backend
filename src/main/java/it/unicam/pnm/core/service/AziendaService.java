package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.AziendaDTOMapper;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaUpdateDTO;
import it.unicam.pnm.inbound.port.AziendaInboundPort;
import it.unicam.pnm.outbound.port.AziendaOutboundPort;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AziendaService implements AziendaInboundPort {

    @Autowired
    private AziendaDTOMapper aziendaMapper;

    @Autowired
    private AziendaOutboundPort aziendaPersistence;

    @Override
    public AziendaDTO create(AziendaCreateDTO dto) {
        AziendaDTO aziendaDto = aziendaMapper.fromCreateDTO(dto);
        //this.validate(aziendaDto);
        return aziendaMapper.toDto(aziendaPersistence.save(aziendaMapper.toModel(aziendaDto)));
    }

    @Override
    public Page<AziendaDTO> search(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaModel> models = aziendaPersistence.search(criteria, pageRequest);
        return models.map(model -> this.aziendaMapper.toDto(model));
    }

    @Override
    public AziendaDTO update(AziendaUpdateDTO dto) {
        this.checkExists(dto.getId());
        AziendaDTO aziendaDto = aziendaMapper.fromUpdateDTO(dto);
        //this.validate(aziendaDto);
        return aziendaMapper.toDto(aziendaPersistence.save(aziendaMapper.toModel(aziendaDto)));
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

}
