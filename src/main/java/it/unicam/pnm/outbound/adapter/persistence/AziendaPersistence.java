package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.AziendaEntityMapper;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.AziendaRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.AziendaSpecification;
import it.unicam.pnm.outbound.port.AziendaOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AziendaPersistence extends AziendaSpecification implements AziendaOutboundPort {

    @Autowired
    private AziendaRepository aziendaRepository;

    @Autowired
    private AziendaEntityMapper aziendaEntityMapper;

    @Override
    public AziendaModel save(AziendaModel model) {
        AziendaEntity entityToSave = aziendaEntityMapper.fromModelToEntity(model);
        AziendaEntity savedEntity = aziendaRepository.save(entityToSave);
        return aziendaEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public List<AziendaModel> findByIds(List<UUID> ids) {
        List<AziendaEntity> entities = aziendaRepository.findAllById(ids);
        return aziendaEntityMapper.fromEntitiesToModels(entities);
    }

    @Override
    public Page<AziendaModel> search(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaEntity> entities = aziendaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.aziendaEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public AziendaModel validateLogin(String user, String pass) {
        return aziendaEntityMapper.fromEntityToModel(aziendaRepository.getByEmailPrivataAndPassword(user, pass));
    }

    @Override
    public boolean existsById(UUID id) {
        return aziendaRepository.existsById(id);
    }

    @Override
    public void setTesseramentoAttivo(UUID id) {
        aziendaRepository.attivaTesseramento(id);
    }

    @Override
    public void delete(UUID id) {
        aziendaRepository.deleteById(id);
    }
}
