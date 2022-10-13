package it.unicam.pnm.core.mapper.outbound;

import it.unicam.pnm.core.mapper.EntityMapper;
import it.unicam.pnm.core.model.ProdottoModel;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProdottoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProdottoEntityMapper extends EntityMapper<ProdottoModel, ProdottoEntity> {

    // add @Mapping(target = "flagElimina", source = "flagElimina", defaultValue = "false")
    //    AnnoEntity fromModelToEntity(AnnoModel model); when mapping defaults
}
