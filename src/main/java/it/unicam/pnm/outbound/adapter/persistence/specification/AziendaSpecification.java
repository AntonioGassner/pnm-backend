package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import org.springframework.data.jpa.domain.Specification;

// TODO aggiungere i filtri in base alle Criteria

public class AziendaSpecification extends AbstractSpecification<AziendaEntity> {

    public Specification<AziendaEntity> filter(AziendaCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<AziendaEntity> specification =
                super.applySearchFilter(criteria.getNome(), "nome")
                        .and(super.applySearchFilter(criteria.getNome(), "cognome"));

        return specification;
    }
}
