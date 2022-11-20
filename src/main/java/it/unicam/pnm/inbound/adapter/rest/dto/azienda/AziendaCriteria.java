package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.UUIDFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class AziendaCriteria {

    List<StringFilter> nome = new ArrayList<>();

    List<StringFilter> partitaIva = new ArrayList<>();

    List<UUIDFilter> produttore = new ArrayList<>();

    List<UUIDFilter> comune = new ArrayList<>();

    List<UUIDFilter> provincia = new ArrayList<>();

}
