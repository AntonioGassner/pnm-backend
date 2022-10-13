package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.ProduttoreModel;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProduttoreDTOMapper extends DTOMapper<ProduttoreDTO, ProduttoreModel> {

    ProduttoreDTO fromCreateDTO(ProduttoreCreateDTO dto);

    ProduttoreDTO fromUpdateDTO(ProduttoreUpdateDTO dto);
}
