package it.unicam.pnm.core.mapper.outbound;

import it.unicam.pnm.core.mapper.EntityMapper;
import it.unicam.pnm.core.model.CategoriaModel;
import it.unicam.pnm.outbound.adapter.persistence.entity.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CategoriaEntityMapper extends EntityMapper<CategoriaModel, CategoriaEntity> {

}
