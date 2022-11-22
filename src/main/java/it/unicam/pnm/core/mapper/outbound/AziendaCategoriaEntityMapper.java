package it.unicam.pnm.core.mapper.outbound;

import it.unicam.pnm.core.mapper.EntityMapper;
import it.unicam.pnm.core.model.AziendaCategoriaModel;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaCategoriaEntity;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AziendaCategoriaEntityMapper extends EntityMapper<AziendaCategoriaModel, AziendaCategoriaEntity> {
}
