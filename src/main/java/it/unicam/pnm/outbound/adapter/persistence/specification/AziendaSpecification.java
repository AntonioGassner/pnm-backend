package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.*;
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

//    protected Specification<AziendaEntity> buildComuneSpecification(AziendaCriteria criteria) {
//        return (root, criteriaQuery, criteriaBuilder) -> {
//
//            Specification<AziendaEntity> specification = Specification.where(null);
//
//            if (criteria.getComune() != null && !criteria.getComune().isEmpty()) {
//
//                // costruisco la join per applicare i criteri di ricerca sul comune
//                Join<AziendaEntity, ComuneEntity> joinComune = root
//                        .join(AziendaEntity_.COMUNE, JoinType.INNER);
//
//                specification = super.applyJoinInFilterGeneric(criteria.getComune(),
//                        ComuneEntity_.ID, joinComune);
//            }
//            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
//        };
//    }
//
//    protected Specification<AziendaEntity> buildProvinciaSpecification(AziendaCriteria criteria) {
//        return (root, criteriaQuery, criteriaBuilder) -> {
//
//            Specification<AziendaEntity> specification = Specification.where(null);
//
//            if (criteria.getProvincia() != null && !criteria.getProvincia().isEmpty()) {
//
//                // costruisco la join per applicare i criteri di ricerca sulla provincia
//                Join<AziendaEntity, ProvinciaEntity> joinProvincia = root
//                        .join(AziendaEntity_.PROVINCIA, JoinType.INNER);
//
//                specification = super.applyJoinInFilterGeneric(criteria.getProvincia(),
//                        ProvinciaEntity_.ID, joinProvincia);
//            }
//            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
//        };
//    }
    
}
