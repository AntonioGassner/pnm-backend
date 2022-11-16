package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.ProvinciaDTOMapper;
import it.unicam.pnm.core.model.ProvinciaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaUpdateDTO;
import it.unicam.pnm.inbound.port.ProvinciaInboundPort;
import it.unicam.pnm.outbound.port.ProvinciaOutboundPort;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProvinciaService implements ProvinciaInboundPort {

    @Autowired
    private ProvinciaDTOMapper provinciaMapper;

    @Autowired
    private ProvinciaOutboundPort provinciaPersistence;
    
    @Override
    public ProvinciaDTO create(ProvinciaCreateDTO dto) {
        ProvinciaDTO provinciaDto = provinciaMapper.fromCreateDTO(dto);
        //this.validate(provinciaDto);
        return provinciaMapper.toDto(provinciaPersistence.save(provinciaMapper.toModel(provinciaDto)));    }

    @Override
    public Page<ProvinciaDTO> search(ProvinciaCriteria criteria, Pageable pageRequest) {
        Page<ProvinciaModel> models = provinciaPersistence.search(criteria, pageRequest);
        return models.map(model -> this.provinciaMapper.toDto(model));    }

    @Override
    public ProvinciaDTO update(ProvinciaUpdateDTO dto) {
        this.checkExists(dto.getId());
        ProvinciaDTO provinciaDto = provinciaMapper.fromUpdateDTO(dto);
        //this.validate(provinciaDto);
        return provinciaMapper.toDto(provinciaPersistence.save(provinciaMapper.toModel(provinciaDto)));    }

    @Override
    public void delete(UUID id) {
        this.checkExists(id);
        provinciaPersistence.delete(id);
    }

    private void checkExists(UUID id){
        if(!provinciaPersistence.existsById(id)){
            throw new NotFoundException(String.format("Provincia %s non trovato", id));
        }
    }

}
