package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.ComuneEntityMapper;
import it.unicam.pnm.core.model.ComuneModel;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.ComuneEntity;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProvinciaEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.ComuneRepository;
import it.unicam.pnm.outbound.adapter.persistence.repository.ProvinciaRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.ComuneSpecification;
import it.unicam.pnm.outbound.port.ComuneOutboundPort;
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
public class ComunePersistence extends ComuneSpecification implements ComuneOutboundPort {

    @Autowired
    private ComuneRepository comuneRepository;

    @Autowired
    private ComuneEntityMapper comuneEntityMapper;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public ComuneModel save(ComuneModel model) {
        ComuneEntity entityToSave = comuneEntityMapper.fromModelToEntity(model);

        if (model.getProvincia() != null && model.getProvincia().getId() != null) {
            ProvinciaEntity provincia = provinciaRepository.findById(model.getProvincia().getId())
                    .stream()
                    .findAny()
                    .orElse(null);
            entityToSave.setProvincia(provincia);
        }

        ComuneEntity savedEntity = comuneRepository.save(entityToSave);
        return comuneEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<ComuneModel> search(ComuneCriteria criteria, Pageable pageRequest) {
        Page<ComuneEntity> entities = comuneRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.comuneEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public ComuneModel getById(UUID id) {
        return comuneEntityMapper.fromEntityToModel(comuneRepository.getReferenceById(id));
    }

    @Override
    public boolean existsById(UUID id) {
        return comuneRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        comuneRepository.deleteById(id);
    }
}
