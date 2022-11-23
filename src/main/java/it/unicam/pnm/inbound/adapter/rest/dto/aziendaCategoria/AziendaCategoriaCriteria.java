package it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria;

import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.UUIDFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class AziendaCategoriaCriteria {

    List<UUID> id = new ArrayList<>();

    List<UUID> azienda = new ArrayList<>();

    List<UUID> categoria = new ArrayList<>();

}
