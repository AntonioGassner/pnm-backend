package it.unicam.pnm.inbound.adapter.rest.dto.comune;

import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.UUIDFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class ComuneCriteria {

    List<StringFilter> nome = new ArrayList<>();

    List<UUIDFilter> provincia = new ArrayList<>();
}
