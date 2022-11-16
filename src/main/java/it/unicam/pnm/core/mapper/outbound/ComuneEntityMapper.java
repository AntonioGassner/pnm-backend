package it.unicam.pnm.core.mapper.outbound;

import it.unicam.pnm.core.mapper.EntityMapper;
import it.unicam.pnm.core.model.ComuneModel;
import it.unicam.pnm.outbound.adapter.persistence.entity.ComuneEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ComuneEntityMapper extends EntityMapper<ComuneModel, ComuneEntity> {
}
