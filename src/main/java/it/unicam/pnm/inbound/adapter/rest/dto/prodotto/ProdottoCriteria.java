package it.unicam.pnm.inbound.adapter.rest.dto.prodotto;

import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProdottoCriteria {

    List<StringFilter> nome = new ArrayList<>();

    List<StringFilter> descrizione = new ArrayList<>();
}
