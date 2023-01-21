package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.AziendaEntityMapper;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import it.unicam.pnm.outbound.adapter.persistence.entity.ComuneEntity;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProduttoreEntity;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProvinciaEntity;
import it.unicam.pnm.outbound.adapter.persistence.repository.AziendaRepository;
import it.unicam.pnm.outbound.adapter.persistence.repository.ComuneRepository;
import it.unicam.pnm.outbound.adapter.persistence.repository.ProvinciaRepository;
import it.unicam.pnm.outbound.adapter.persistence.specification.AziendaSpecification;
import it.unicam.pnm.outbound.port.AziendaOutboundPort;
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
public class AziendaPersistence extends AziendaSpecification implements AziendaOutboundPort {

    @Autowired
    private AziendaRepository aziendaRepository;

    @Autowired
    private AziendaEntityMapper aziendaEntityMapper;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private ComuneRepository comuneRepository;

    @Autowired
    private ProduttoreRepository produttoreRepository;

    @Override
    public AziendaModel save(AziendaModel model) {
        AziendaEntity entityToSave = aziendaEntityMapper.fromModelToEntity(model);

        if (model.getProvincia() != null && model.getProvincia().getId() != null) {
            ProvinciaEntity provincia = provinciaRepository.findById(model.getProvincia().getId())
                    .stream()
                    .findAny()
                    .orElse(null);
            entityToSave.setProvincia(provincia);
        }

        if (model.getComune() != null && model.getComune().getId() != null) {
            ComuneEntity comune = comuneRepository.findById(model.getComune().getId())
                    .stream()
                    .findAny()
                    .orElse(null);
            entityToSave.setComune(comune);
        }

        if (model.getProduttore() != null && model.getProduttore().getId() != null) {
            ProduttoreEntity produttore = produttoreRepository.findById(model.getProduttore().getId())
                    .stream()
                    .findAny()
                    .orElse(null);
            entityToSave.setProduttore(produttore);
        }

        AziendaEntity savedEntity = aziendaRepository.save(entityToSave);
        return aziendaEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<AziendaModel> search(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaEntity> entities = aziendaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.aziendaEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public AziendaModel getById(UUID id) {
        return aziendaEntityMapper.fromEntityToModel(aziendaRepository.getReferenceById(id));
    }

    @Override
    public boolean existsById(UUID id) {
        return aziendaRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        aziendaRepository.deleteById(id);
    }
}
