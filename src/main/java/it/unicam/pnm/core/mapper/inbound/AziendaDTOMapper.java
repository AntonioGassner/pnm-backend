package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
 //       ProvinciaDTOMapper.class, ComuneDTOMapper.class
})
public interface AziendaDTOMapper extends DTOMapper<AziendaDTO, AziendaModel> {

//    @Mapping(target = "provincia.id", source = "provincia")
//    @Mapping(target = "comune.id", source = "comune")
    AziendaDTO fromCreateDTO(AziendaCreateDTO dto);

//    @Mapping(target = "provincia.id", source = "provincia")
//    @Mapping(target = "comune.id", source = "comune")
    AziendaDTO fromUpdateDTO(AziendaUpdateDTO dto);
}
