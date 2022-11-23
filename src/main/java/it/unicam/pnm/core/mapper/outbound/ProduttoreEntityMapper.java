package it.unicam.pnm.core.mapper.outbound;

import it.unicam.pnm.core.mapper.EntityMapper;
import it.unicam.pnm.core.model.ProduttoreModel;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProduttoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ProduttoreEntityMapper extends EntityMapper<ProduttoreModel, ProduttoreEntity> {

    @Mapping(target = "tesseramentoAttivo", source = "tesseramentoAttivo", defaultValue = "false")
    ProduttoreEntity fromModelToEntity(ProduttoreModel model);

}
