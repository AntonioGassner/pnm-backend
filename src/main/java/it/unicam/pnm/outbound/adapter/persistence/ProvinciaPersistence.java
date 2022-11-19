package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.ProvinciaEntityMapper;
import it.unicam.pnm.core.model.ProvinciaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProvinciaEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.ProvinciaRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.ProvinciaSpecification;
import it.unicam.pnm.outbound.port.ProvinciaOutboundPort;
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
public class ProvinciaPersistence extends ProvinciaSpecification implements ProvinciaOutboundPort {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private ProvinciaEntityMapper provinciaEntityMapper;

    @Override
    public ProvinciaModel save(ProvinciaModel model) {
        ProvinciaEntity entityToSave = provinciaEntityMapper.fromModelToEntity(model);
        ProvinciaEntity savedEntity = provinciaRepository.save(entityToSave);
        return provinciaEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<ProvinciaModel> search(ProvinciaCriteria criteria, Pageable pageRequest) {
        Page<ProvinciaEntity> entities = provinciaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.provinciaEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public ProvinciaModel getById(UUID id) {
        return provinciaEntityMapper.fromEntityToModel(provinciaRepository.getReferenceById(id));
    }

    @Override
    public boolean existsById(UUID id) {
        return provinciaRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        provinciaRepository.deleteById(id);
    }
}
