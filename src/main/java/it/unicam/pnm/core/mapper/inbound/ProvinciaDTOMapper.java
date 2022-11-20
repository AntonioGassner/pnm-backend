package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.ProvinciaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProvinciaDTOMapper extends DTOMapper<ProvinciaDTO, ProvinciaModel> {

    ProvinciaDTO fromCreateDTO(ProvinciaCreateDTO dto);

    ProvinciaDTO fromUpdateDTO(ProvinciaUpdateDTO dto);
}
