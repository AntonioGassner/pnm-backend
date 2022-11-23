package it.unicam.pnm.inbound.adapter.rest.dto.comune;

import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.UUIDFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ComuneCriteria {

    List<UUID> id = new ArrayList<>();

    List<StringFilter> nome = new ArrayList<>();

    List<UUID> provincia = new ArrayList<>();
}
