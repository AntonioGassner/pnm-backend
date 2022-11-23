package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.AziendaCategoriaDTOMapper;
import it.unicam.pnm.core.mapper.inbound.AziendaDTOMapper;
import it.unicam.pnm.core.model.AziendaCategoriaModel;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaUpdateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaUpdateDTO;
import it.unicam.pnm.inbound.port.AziendaCategoriaInboundPort;
import it.unicam.pnm.inbound.port.AziendaInboundPort;
import it.unicam.pnm.outbound.port.*;
import it.unicam.pnm.web.rest.errors.BadRequestException;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AziendaCategoriaService implements AziendaCategoriaInboundPort {

    @Autowired
    private AziendaCategoriaDTOMapper aziendaCategoriaMapper;

    @Autowired
    private AziendaCategoriaOutboundPort aziendaCategoriaPersistence;
    @Autowired
    private AziendaOutboundPort aziendaPersistence;

    @Autowired
    private CategoriaOutboundPort categoriaPersistence;


    @Override
    public AziendaCategoriaDTO create(AziendaCategoriaCreateDTO dto) {
        AziendaCategoriaDTO aziendaCategoriaDto = aziendaCategoriaMapper.fromCreateDTO(dto);
        this.validate(aziendaCategoriaDto);
        return aziendaCategoriaMapper.toDto(aziendaCategoriaPersistence.save(aziendaCategoriaMapper.toModel(aziendaCategoriaDto)));
    }

    @Override
    public Page<AziendaCategoriaDTO> search(AziendaCategoriaCriteria criteria, Pageable pageRequest) {
        Page<AziendaCategoriaModel> models = aziendaCategoriaPersistence.search(criteria, pageRequest);
        return models.map(model -> this.aziendaCategoriaMapper.toDto(model));
    }

    @Override
    public AziendaCategoriaDTO update(AziendaCategoriaUpdateDTO dto) {
        this.checkExists(dto.getId());
        AziendaCategoriaDTO aziendaCategoriaDto = aziendaCategoriaMapper.fromUpdateDTO(dto);
        this.validate(aziendaCategoriaDto);
        return aziendaCategoriaMapper.toDto(aziendaCategoriaPersistence.save(aziendaCategoriaMapper.toModel(aziendaCategoriaDto)));
    }

    @Override
    public void delete(UUID id) {
        this.checkExists(id);
        aziendaCategoriaPersistence.delete(id);
    }

    private void checkExists(UUID id) {
        if (!aziendaCategoriaPersistence.existsById(id)) {
            throw new NotFoundException(String.format("Azienda %s non trovato", id));
        }
    }

    private void validate(AziendaCategoriaDTO dto){

        boolean error = false;
        String error_validate = "";

        if (!aziendaPersistence.existsById(dto.getAzienda().getId())) {
            error = true;
            error_validate += "Azienda";
        }

        if (!categoriaPersistence.existsById(dto.getCategoria().getId())) {
            if (!error_validate.equals(""))
                error_validate += ", ";
            error = true;
            error_validate += "Categoria";
        }

        if (error) {
            // TODO logging
            //log.warn("DomandaDieta error: {}", error_validate);
            throw new BadRequestException(String.format("Errore creazione Azienda : %s non trovato", error_validate));
        }
    }

}
