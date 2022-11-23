package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.*;
import it.unicam.pnm.outbound.adapter.persistence.entity.ComuneEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class ComuneSpecification extends AbstractSpecification<ComuneEntity> {

    public Specification<ComuneEntity> filter(ComuneCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<ComuneEntity> specification =
                super.applyInUUIDFilter(criteria.getId(), "id")
                        .and(super.applySearchFilter(criteria.getNome(), "nome"))
                        .and(this.buildProvinciaSpecification(criteria));

        return specification;
    }

    protected Specification<ComuneEntity> buildProvinciaSpecification(ComuneCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {

            Specification<ComuneEntity> specification = Specification.where(null);

            if (criteria.getProvincia() != null && !criteria.getProvincia().isEmpty()) {

                // costruisco la join per applicare i criteri di ricerca sulla provincia
                Join<ComuneEntity, ProvinciaEntity> joinProvincia = root
                        .join(ComuneEntity_.PROVINCIA, JoinType.INNER);

                specification = super.applyJoinInFilterGeneric(criteria.getProvincia(),
                        ProvinciaEntity_.ID, joinProvincia);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        };
    }
}
