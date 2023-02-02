package it.unicam.pnm.outbound.adapter.persistence;

import it.unicam.pnm.core.mapper.outbound.AziendaEntityMapper;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.*;
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

//    @Autowired
//    private ProvinciaRepository provinciaRepository;
//
//    @Autowired
//    private ComuneRepository comuneRepository;

    @Override
    public AziendaModel save(AziendaModel model) {
        AziendaEntity entityToSave = aziendaEntityMapper.fromModelToEntity(model);

//        if (model.getProvincia() != null && model.getProvincia().getId() != null) {
//            ProvinciaEntity provincia = provinciaRepository.findById(model.getProvincia().getId())
//                    .stream()
//                    .findAny()
//                    .orElse(null);
//            entityToSave.setProvincia(provincia);
//        }
//
//        if (model.getComune() != null && model.getComune().getId() != null) {
//            ComuneEntity comune = comuneRepository.findById(model.getComune().getId())
//                    .stream()
//                    .findAny()
//                    .orElse(null);
//            entityToSave.setComune(comune);
//        }


        AziendaEntity savedEntity = aziendaRepository.save(entityToSave);
        return aziendaEntityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<AziendaModel> searchPreview(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaEntity> entities = aziendaRepository.getAziendaPreviewByNomeAziendaAndProvinciaAndTipoProdotto(criteria.getNomeAzienda().toString(), criteria.getProvincia().toString(), criteria.getTipoProdotto().toString(), pageRequest);
        return entities.map(entity -> this.aziendaEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public Page<AziendaModel> search(AziendaCriteria criteria, Pageable pageRequest) {
        Page<AziendaEntity> entities = aziendaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.aziendaEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public AziendaModel getDettaglioById(UUID id) {
        return aziendaEntityMapper.fromEntityToModel(aziendaRepository.getAziendaDettaglioById(id));
    }

    @Override
    public Page<AziendaModel> getContactList() {
        Page<AziendaEntity> entities = aziendaRepository.getContactList();
        return entities.map(entity -> this.aziendaEntityMapper.fromEntityToModel(entity));
    }

    @Override
    public AziendaModel getById(UUID id) {
        return aziendaEntityMapper.fromEntityToModel(aziendaRepository.getReferenceById(id));
    }

    @Override
    public boolean validateLogin(String user, String pass){
        return this.aziendaRepository.existsByEmailPrivataAndPassword(user, pass);
    }


    @Override
    public boolean existsById(UUID id) {
        return aziendaRepository.existsById(id);
    }

    @Override
    public void attivaTesseramento(UUID id) {
        aziendaRepository.attivaTesseramento(id);
    }

    @Override
    public void delete(UUID id) {
        aziendaRepository.deleteById(id);
    }
}
