package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.*;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;


public class AziendaCategoriaSpecification extends AbstractSpecification<AziendaCategoriaEntity> {

    public Specification<AziendaCategoriaEntity> filter(AziendaCategoriaCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<AziendaCategoriaEntity> specification =
                super.applyUUIDFilter(criteria.getId(), "id")
                        .and(this.buildAziendaSpecification(criteria))
                        .and(this.buildCategoriaSpecification(criteria));

        return specification;
    }

    protected Specification<AziendaCategoriaEntity> buildAziendaSpecification(AziendaCategoriaCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {

            Specification<AziendaCategoriaEntity> specification = Specification.where(null);

            if (criteria.getAzienda() != null && !criteria.getAzienda().isEmpty()) {

                // costruisco la join per applicare i criteri di ricerca sul'azienda
                Join<AziendaCategoriaEntity, AziendaEntity> joinAzienda = root
                        .join(AziendaCategoriaEntity_.AZIENDA, JoinType.INNER);

                specification = super.applyJoinInFilterGeneric(criteria.getAzienda(),
                        AziendaEntity_.ID, joinAzienda);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        };
    }

    protected Specification<AziendaCategoriaEntity> buildCategoriaSpecification(AziendaCategoriaCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {

            Specification<AziendaCategoriaEntity> specification = Specification.where(null);

            if (criteria.getCategoria() != null && !criteria.getCategoria().isEmpty()) {

                // costruisco la join per applicare i criteri di ricerca sulla categoria
                Join<AziendaCategoriaEntity, CategoriaEntity> joinCategoria = root
                        .join(AziendaCategoriaEntity_.CATEGORIA, JoinType.INNER);

                specification = super.applyJoinInFilterGeneric(criteria.getCategoria(),
                        CategoriaEntity_.ID, joinCategoria);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        };
    }
}
