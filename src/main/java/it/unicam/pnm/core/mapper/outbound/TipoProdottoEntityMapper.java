package it.unicam.pnm.core.mapper.outbound;

import it.unicam.pnm.core.mapper.EntityMapper;
import it.unicam.pnm.core.model.TipoProdottoModel;
import it.unicam.pnm.outbound.adapter.persistence.entity.TipoProdottoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TipoProdottoEntityMapper extends EntityMapper<TipoProdottoModel, TipoProdottoEntity> {

    // add @Mapping(target = "flagElimina", source = "flagElimina", defaultValue = "false")
    //    AnnoEntity fromModelToEntity(AnnoModel model); when mapping defaults
}
