package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.ProdottoModel;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoUpdateDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

// @Mapper(componentModel = "spring", uses = {ClasseComposizioneModelMapper.class, RefettorioModelMapper.class, TurnoModelMapper.class})
@Mapper(componentModel = "spring", uses = {})
public interface ProdottoDTOMapper extends DTOMapper<ProdottoDTO, ProdottoModel> {

    ProdottoDTO fromUpdateDTO(ProdottoUpdateDTO dto);

    ProdottoDTO fromCreateDTO(ProdottoCreateDTO dto);

    // @Mapping(target = "classeComposizione.id", source = "classeComposizione")
    //    @Mapping(target = "refettorio.id", source = "refettorio")
    //    @Mapping(target = "anno.anno", source = "anno")
    //    @Mapping(target = "turno.id", source = "turno")
    //    ClasseComposizioneAnnoDTO fromUpdateDto(ClasseComposizioneAnnoUpdateDTO dto);
}
