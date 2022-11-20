package it.unicam.pnm.core.mapper.outbound;

import it.unicam.pnm.core.mapper.EntityMapper;
import it.unicam.pnm.core.model.ProvinciaModel;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProvinciaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProvinciaEntityMapper extends EntityMapper<ProvinciaModel, ProvinciaEntity> {
}
