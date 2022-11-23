package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class AziendaSpecification extends AbstractSpecification<AziendaEntity> {

    public Specification<AziendaEntity> filter(AziendaCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<AziendaEntity> specification =
                super.applyUUIDFilter(criteria.getId(), "id")
                        .and(super.applySearchFilter(criteria.getNome(), "nome"))
                        .and(this.buildProduttoreSpecification(criteria))
                        .and(this.buildComuneSpecification(criteria))
                        .and(this.buildProvinciaSpecification(criteria));

        return specification;
    }
    
    protected Specification<AziendaEntity> buildProduttoreSpecification(AziendaCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {

            Specification<AziendaEntity> specification = Specification.where(null);

            if (criteria.getProduttore() != null && !criteria.getProduttore().isEmpty()) {

                // costruisco la join per applicare i criteri di ricerca sul produttore
                Join<AziendaEntity, ProduttoreEntity> joinProduttore = root
                        .join(AziendaEntity_.PRODUTTORE, JoinType.INNER);

                specification = super.applyJoinInFilterGeneric(criteria.getProduttore(),
                        ProduttoreEntity_.ID, joinProduttore);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        };
    }

    protected Specification<AziendaEntity> buildComuneSpecification(AziendaCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {

            Specification<AziendaEntity> specification = Specification.where(null);

            if (criteria.getComune() != null && !criteria.getComune().isEmpty()) {

                // costruisco la join per applicare i criteri di ricerca sul comune
                Join<AziendaEntity, ComuneEntity> joinComune = root
                        .join(AziendaEntity_.COMUNE, JoinType.INNER);

                specification = super.applyJoinInFilterGeneric(criteria.getComune(),
                        ComuneEntity_.ID, joinComune);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        };
    }

    protected Specification<AziendaEntity> buildProvinciaSpecification(AziendaCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) -> {

            Specification<AziendaEntity> specification = Specification.where(null);

            if (criteria.getProvincia() != null && !criteria.getProvincia().isEmpty()) {

                // costruisco la join per applicare i criteri di ricerca sulla provincia
                Join<AziendaEntity, ProvinciaEntity> joinProvincia = root
                        .join(AziendaEntity_.PROVINCIA, JoinType.INNER);

                specification = super.applyJoinInFilterGeneric(criteria.getProvincia(),
                        ProvinciaEntity_.ID, joinProvincia);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        };
    }
    
}
