package it.unicam.pnm.inbound.adapter.rest.dto.produttore;

import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProduttoreCriteria {

    List<UUID> id = new ArrayList<>();

    List<StringFilter> nome = new ArrayList<>();

    List<StringFilter> cognome = new ArrayList<>();

}
