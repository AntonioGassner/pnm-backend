package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.AziendaCategoriaEntityMapper;
import it.unicam.pnm.core.model.AziendaCategoriaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaCategoriaEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.AziendaCategoriaRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.AziendaCategoriaSpecification;
import it.unicam.pnm.outbound.port.AziendaCategoriaOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AziendaCategoriaPersistence extends AziendaCategoriaSpecification implements AziendaCategoriaOutboundPort {

    @Autowired
    private AziendaCategoriaRepository aziendaCategoriaRepository;

    @Autowired
    private AziendaCategoriaEntityMapper aziendaCategoriaEntityMapper;

    @Override
    public AziendaCategoriaModel save(AziendaCategoriaModel model) {
        AziendaCategoriaEntity entityToSave = aziendaCategoriaEntityMapper.fromModelToEntity(model);
        AziendaCategoriaEntity savedEntity = aziendaCategoriaRepository.save(entityToSave);
        return aziendaCategoriaEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<AziendaCategoriaModel> search(AziendaCategoriaCriteria criteria, Pageable pageRequest) {
        Page<AziendaCategoriaEntity> entities = aziendaCategoriaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.aziendaCategoriaEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public AziendaCategoriaModel getById(UUID id) {
        return aziendaCategoriaEntityMapper.fromEntityToModel(aziendaCategoriaRepository.getReferenceById(id));
    }

    @Override
    public boolean existsById(UUID id) {
        return aziendaCategoriaRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        aziendaCategoriaRepository.deleteById(id);
    }
}
