package it.unicam.pnm.core.mapper.outbound;

import it.unicam.pnm.core.mapper.EntityMapper;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AziendaEntityMapper extends EntityMapper<AziendaModel, AziendaEntity> {

}
