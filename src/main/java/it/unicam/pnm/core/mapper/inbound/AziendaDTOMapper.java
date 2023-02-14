package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AziendaDTOMapper extends DTOMapper<AziendaDTO, AziendaModel> {

    AziendaDTO fromCreateDTO(AziendaCreateDTO dto);

    AziendaDTO fromUpdateDTO(AziendaUpdateDTO dto);
}
