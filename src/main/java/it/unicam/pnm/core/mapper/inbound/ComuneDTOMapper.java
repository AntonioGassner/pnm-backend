package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.ComuneModel;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProvinciaDTOMapper.class})
public interface ComuneDTOMapper extends DTOMapper<ComuneDTO, ComuneModel> {

    @Mapping(target = "provincia.id", source = "provincia")
    ComuneDTO fromCreateDTO(ComuneCreateDTO dto);

    @Mapping(target = "provincia.id", source = "provincia")
    ComuneDTO fromUpdateDTO(ComuneUpdateDTO dto);
}
