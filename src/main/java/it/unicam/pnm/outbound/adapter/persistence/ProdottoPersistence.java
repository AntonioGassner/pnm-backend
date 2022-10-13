package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.ProdottoEntityMapper;
import it.unicam.pnm.core.model.ProdottoModel;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProdottoEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.ProdottoRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.ProdottoSpecification;
import it.unicam.pnm.outbound.port.ProdottoOutboundPort;
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
public class ProdottoPersistence extends ProdottoSpecification implements ProdottoOutboundPort {

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private ProdottoEntityMapper prodottoEntityMapper;

    @Override
    public ProdottoModel save(ProdottoModel model) {
        ProdottoEntity entityToSave = prodottoEntityMapper.fromModelToEntity(model);
        ProdottoEntity savedEntity = prodottoRepository.save(entityToSave);
        return prodottoEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<ProdottoModel> search(ProdottoCriteria criteria, Pageable pageRequest) {
        Page<ProdottoEntity> entities = prodottoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.prodottoEntityMapper.fromEntityToModel(entity)) ;
    }

    @Override
    public ProdottoModel getById(UUID id) {
        return prodottoEntityMapper.fromEntityToModel(prodottoRepository.getReferenceById(id));
    }

    @Override
    public boolean existsById(UUID id) {
        return prodottoRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        prodottoRepository.deleteById(id);
    }
}
