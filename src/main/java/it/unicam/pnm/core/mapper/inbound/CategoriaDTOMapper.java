package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.CategoriaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CategoriaDTOMapper extends DTOMapper<CategoriaDTO, CategoriaModel> {

    CategoriaDTO fromUpdateDTO(CategoriaUpdateDTO dto);

    CategoriaDTO fromCreateDTO(CategoriaCreateDTO dto);

}
