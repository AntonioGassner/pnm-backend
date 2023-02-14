package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import org.springframework.data.jpa.domain.Specification;

public class AziendaSpecification extends AbstractSpecification<AziendaEntity> {

    public Specification<AziendaEntity> filter(AziendaCriteria criteria) {

        String flagName = "tesseramentoAttivo";
        boolean flagValue = true;

        Specification<AziendaEntity> specification =
                super.flagSpecification(flagName, flagValue)
                        .and(super.applyInUUIDFilter(criteria.getId(), "id"))
                        .and(super.applySearchFilter(criteria.getNomeAzienda(), "nomeAzienda"))
                        .and(super.applySearchFilter(criteria.getProvincia(), "provincia"))
                        .and(super.applySearchFilter(criteria.getTipoProdotto(), "tipoProdotto"));
        return specification;
    }

}
