package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class AziendaCriteria {

    List<UUID> id = new ArrayList<>();

    List<StringFilter> nomeAzienda;

    List<StringFilter> provincia;

    List<StringFilter> tipoProdotto;

}
