package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.AziendaCategoriaModel;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaUpdateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AziendaDTOMapper.class, CategoriaDTOMapper.class})
public interface AziendaCategoriaDTOMapper extends DTOMapper<AziendaCategoriaDTO, AziendaCategoriaModel> {

    @Mapping(target = "azienda.id", source = "azienda")
    @Mapping(target = "categoria.id", source = "categoria")
    AziendaCategoriaDTO fromCreateDTO(AziendaCategoriaCreateDTO dto);

    @Mapping(target = "azienda.id", source = "azienda")
    @Mapping(target = "categoria.id", source = "categoria")
    AziendaCategoriaDTO fromUpdateDTO(AziendaCategoriaUpdateDTO dto);

}
