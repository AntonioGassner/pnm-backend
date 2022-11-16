package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.ComuneEntity;
import org.springframework.data.jpa.domain.Specification;

// TODO aggiungere i filtri in base alle Criteria

public class ComuneSpecification extends AbstractSpecification<ComuneEntity> {

    public Specification<ComuneEntity> filter(ComuneCriteria criteria){

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<ComuneEntity> specification =
                super.applySearchFilter(criteria.getNome(), "nome")
                .and(super.applySearchFilter(criteria.getNome(), "cognome"));

                return specification;
    }
}
