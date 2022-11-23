package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProvinciaEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProvinciaSpecification extends AbstractSpecification<ProvinciaEntity> {

    public Specification<ProvinciaEntity> filter(ProvinciaCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<ProvinciaEntity> specification =
                super.applyUUIDFilter(criteria.getId(), "id")
                        .and(super.applySearchFilter(criteria.getNome(), "nome"));
        return specification;
    }
}
