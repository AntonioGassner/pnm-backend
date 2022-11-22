package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProduttoreEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProduttoreSpecification extends AbstractSpecification<ProduttoreEntity> {

    public Specification<ProduttoreEntity> filter(ProduttoreCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<ProduttoreEntity> specification =
                super.applySearchFilter(criteria.getNome(), "nome")
                        .and(super.applySearchFilter(criteria.getCognome(), "cognome"));

        return specification;
    }
}
