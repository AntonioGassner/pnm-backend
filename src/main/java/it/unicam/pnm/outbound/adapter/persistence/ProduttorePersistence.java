package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.ProduttoreEntityMapper;
import it.unicam.pnm.core.model.ProduttoreModel;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProduttoreEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.ProduttoreRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.ProduttoreSpecification;
import it.unicam.pnm.outbound.port.ProduttoreOutboundPort;
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
public class ProduttorePersistence extends ProduttoreSpecification implements ProduttoreOutboundPort {

    @Autowired
    private ProduttoreRepository produttoreRepository;

    @Autowired
    private ProduttoreEntityMapper produttoreEntityMapper;

    @Override
    public ProduttoreModel save(ProduttoreModel model) {
        ProduttoreEntity entityToSave = produttoreEntityMapper.fromModelToEntity(model);
        ProduttoreEntity savedEntity = produttoreRepository.save(entityToSave);
        return produttoreEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<ProduttoreModel> search(ProduttoreCriteria criteria, Pageable pageRequest) {
        Page<ProduttoreEntity> entities = produttoreRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.produttoreEntityMapper.fromEntityToModel(entity)) ;
    }

    @Override
    public ProduttoreModel getById(UUID id) {
        return produttoreEntityMapper.fromEntityToModel(produttoreRepository.getReferenceById(id));
    }

    @Override
    public boolean existsById(UUID id) {
        return produttoreRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        produttoreRepository.deleteById(id);
    }
}
