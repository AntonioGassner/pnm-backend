package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.CategoriaEntityMapper;
import it.unicam.pnm.core.model.CategoriaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.CategoriaEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.CategoriaRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.CategoriaSpecification;
import it.unicam.pnm.outbound.port.CategoriaOutboundPort;
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
public class CategoriaPersistence extends CategoriaSpecification implements CategoriaOutboundPort {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaEntityMapper categoriaEntityMapper;

    @Override
    public CategoriaModel save(CategoriaModel model) {
        CategoriaEntity entityToSave = categoriaEntityMapper.fromModelToEntity(model);
        CategoriaEntity savedEntity = categoriaRepository.save(entityToSave);
        return categoriaEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<CategoriaModel> search(CategoriaCriteria criteria, Pageable pageRequest) {
        Page<CategoriaEntity> entities = categoriaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.categoriaEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public CategoriaModel getById(UUID id) {
        return categoriaEntityMapper.fromEntityToModel(categoriaRepository.getReferenceById(id));
    }

    @Override
    public boolean existsById(UUID id) {
        return categoriaRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        categoriaRepository.deleteById(id);
    }
}
