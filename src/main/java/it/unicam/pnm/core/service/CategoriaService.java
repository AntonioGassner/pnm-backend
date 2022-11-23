package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.CategoriaDTOMapper;
import it.unicam.pnm.core.model.CategoriaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaUpdateDTO;
import it.unicam.pnm.inbound.port.CategoriaInboundPort;
import it.unicam.pnm.outbound.port.CategoriaOutboundPort;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoriaService implements CategoriaInboundPort {

    @Autowired
    private CategoriaDTOMapper categoriaMapper;

    @Autowired
    private CategoriaOutboundPort categoriaPersistence;

    @Override
    public CategoriaDTO create(CategoriaCreateDTO dto) {
        CategoriaDTO categoriaDto = categoriaMapper.fromCreateDTO(dto);
        //this.validate(categoriaDto);
        return categoriaMapper.toDto(categoriaPersistence.save(categoriaMapper.toModel(categoriaDto)));
    }

    @Override
    public Page<CategoriaDTO> search(CategoriaCriteria criteria, Pageable pageRequest) {
        Page<CategoriaModel> models = categoriaPersistence.search(criteria, pageRequest);
        return models.map(model -> this.categoriaMapper.toDto(model));
    }

    @Override
    public CategoriaDTO update(CategoriaUpdateDTO dto) {
        this.checkExists(dto.getId());
        CategoriaDTO categoriaDto = categoriaMapper.fromUpdateDTO(dto);
        //this.validate(categoriaDto);
        return categoriaMapper.toDto(categoriaPersistence.save(categoriaMapper.toModel(categoriaDto)));
    }

    @Override
    public void delete(UUID id) {
        this.checkExists(id);
        categoriaPersistence.delete(id);
    }

    private void checkExists(UUID id) {
        if (!categoriaPersistence.existsById(id)) {
            throw new NotFoundException(String.format("Categoria %s non trovato", id));
        }
    }

}

/*

// TODO checkInUse

private void checkInUse(UUID id) {

        boolean error = false;
        String error_validate = "";

        if (this.assenzaPersistence.containsClasseComposizione(id)) {
            error = true;
            error_validate += "Assenza";
        }

        if (this.classeComposizioneAnnoPersistence.containsClasseComposizione(id)) {
            if (!error_validate.equals(""))
                error_validate += ", ";
            error = true;
            error_validate += "ClasseComposizioneAnno";
        }

        if (this.giornoRefezionabilePersistence.containsClasseComposizione(id)) {
            if (!error_validate.equals(""))
                error_validate += ", ";
            error = true;
            error_validate += "GiornoRefezionabile";
        }

        if (error) {
            log.warn("ClasseComposizione error: {}", error_validate);
            throw new BadRequestException(String.format("Errore eliminazione ClasseComposizione, utilizzato da: %s ", error_validate));
        }
    }
 */