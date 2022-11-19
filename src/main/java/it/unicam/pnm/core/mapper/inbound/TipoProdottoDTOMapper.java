package it.unicam.pnm.core.mapper.inbound;

import it.unicam.pnm.core.mapper.DTOMapper;
import it.unicam.pnm.core.model.TipoProdottoModel;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoUpdateDTO;
import org.mapstruct.Mapper;

// @Mapper(componentModel = "spring", uses = {ClasseComposizioneModelMapper.class, RefettorioModelMapper.class, TurnoModelMapper.class})
@Mapper(componentModel = "spring", uses = {})
public interface TipoProdottoDTOMapper extends DTOMapper<TipoProdottoDTO, TipoProdottoModel> {

    TipoProdottoDTO fromUpdateDTO(TipoProdottoUpdateDTO dto);

    TipoProdottoDTO fromCreateDTO(TipoProdottoCreateDTO dto);

    // @Mapping(target = "classeComposizione.id", source = "classeComposizione")
    //    @Mapping(target = "refettorio.id", source = "refettorio")
    //    @Mapping(target = "anno.anno", source = "anno")
    //    @Mapping(target = "turno.id", source = "turno")
    //    ClasseComposizioneAnnoDTO fromUpdateDto(ClasseComposizioneAnnoUpdateDTO dto);
}
