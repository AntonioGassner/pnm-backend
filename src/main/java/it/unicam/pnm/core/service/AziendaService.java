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

import java.util.List;
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
        return aziendaMapper.toDto(aziendaPersistence.save(aziendaMapper.toModel(aziendaDto)));
    }

    @Override
    public List<AziendaDTO> findByIds(List<UUID> ids) {
        List<AziendaModel> models = aziendaPersistence.findByIds(ids);
        return aziendaMapper.toDto(models);
    }

    @Override
    public Page<AziendaDTO> search(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaModel> models = aziendaPersistence.search(criteria, pageRequest);
        return models.map(model -> this.aziendaMapper.toDto(model));
    }

    @Override
    public AziendaDTO validateLogin(String user, String pass) {
        return aziendaMapper.toDto(aziendaPersistence.validateLogin(user, pass));
    }

    @Override
    public AziendaDTO update(AziendaUpdateDTO dto) {
        this.checkExists(dto.getId());
        AziendaDTO aziendaDto = aziendaMapper.fromUpdateDTO(dto);
        return aziendaMapper.toDto(aziendaPersistence.save(aziendaMapper.toModel(aziendaDto)));
    }

    @Override
    public void setTesseramentoAttivo(UUID id) {
        aziendaPersistence.setTesseramentoAttivo(id);
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
