package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.ProduttoreDTOMapper;
import it.unicam.pnm.core.model.ProduttoreModel;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreUpdateDTO;
import it.unicam.pnm.inbound.port.ProduttoreInboundPort;
import it.unicam.pnm.outbound.port.ProduttoreOutboundPort;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProduttoreService implements ProduttoreInboundPort {

    @Autowired
    private ProduttoreDTOMapper produttoreMapper;

    @Autowired
    private ProduttoreOutboundPort produttorePersistence;

    @Override
    public ProduttoreDTO create(ProduttoreCreateDTO dto) {
        ProduttoreDTO produttoreDto = produttoreMapper.fromCreateDTO(dto);
        //this.validate(produttoreDto);
        return produttoreMapper.toDto(produttorePersistence.save(produttoreMapper.toModel(produttoreDto)));
    }

    @Override
    public Page<ProduttoreDTO> search(ProduttoreCriteria criteria, Pageable pageRequest) {
        Page<ProduttoreModel> models = produttorePersistence.search(criteria, pageRequest);
        return models.map(model -> this.produttoreMapper.toDto(model));
    }

    @Override
    public ProduttoreDTO update(ProduttoreUpdateDTO dto) {
        this.checkExists(dto.getId());
        ProduttoreDTO produttoreDto = produttoreMapper.fromUpdateDTO(dto);
        //this.validate(produttoreDto);
        return produttoreMapper.toDto(produttorePersistence.save(produttoreMapper.toModel(produttoreDto)));
    }

    @Override
    public void delete(UUID id) {
        this.checkExists(id);
        produttorePersistence.delete(id);
    }

    private void checkExists(UUID id) {
        if (!produttorePersistence.existsById(id)) {
            throw new NotFoundException(String.format("Produttore %s non trovato", id));
        }
    }

}
