package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class AziendaCriteria {

    List<StringFilter> nome = new ArrayList<>();

    List<StringFilter> cognome = new ArrayList<>();

    List<StringFilter> codiceFiscale = new ArrayList<>();

    List<StringFilter> partitaIva = new ArrayList<>();

}