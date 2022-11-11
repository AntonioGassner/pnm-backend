package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.TipoProdottoEntityMapper;
import it.unicam.pnm.core.model.TipoProdottoModel;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.TipoProdottoEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.TipoProdottoRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.TipoProdottoSpecification;
import it.unicam.pnm.outbound.port.TipoProdottoOutboundPort;
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
public class TipoProdottoPersistence extends TipoProdottoSpecification implements TipoProdottoOutboundPort {

    @Autowired
    private TipoProdottoRepository tipoProdottoRepository;

    @Autowired
    private TipoProdottoEntityMapper tipoProdottoEntityMapper;

    @Override
    public TipoProdottoModel save(TipoProdottoModel model) {
        TipoProdottoEntity entityToSave = tipoProdottoEntityMapper.fromModelToEntity(model);
        TipoProdottoEntity savedEntity = tipoProdottoRepository.save(entityToSave);
        return tipoProdottoEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<TipoProdottoModel> search(TipoProdottoCriteria criteria, Pageable pageRequest) {
        Page<TipoProdottoEntity> entities = tipoProdottoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.tipoProdottoEntityMapper.fromEntityToModel(entity)) ;
    }

    @Override
    public TipoProdottoModel getById(UUID id) {
        return tipoProdottoEntityMapper.fromEntityToModel(tipoProdottoRepository.getReferenceById(id));
    }

    @Override
    public boolean existsById(UUID id) {
        return tipoProdottoRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        tipoProdottoRepository.deleteById(id);
    }
}
