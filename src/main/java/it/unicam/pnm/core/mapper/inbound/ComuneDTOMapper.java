package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.ComuneModel;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ComuneDTOMapper extends DTOMapper<ComuneDTO, ComuneModel> {

    ComuneDTO fromCreateDTO(ComuneCreateDTO dto);

    ComuneDTO fromUpdateDTO(ComuneUpdateDTO dto);
}
