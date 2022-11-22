package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import org.springframework.data.jpa.domain.Specification;

public class AziendaSpecification extends AbstractSpecification<AziendaEntity> {

    public Specification<AziendaEntity> filter(AziendaCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<AziendaEntity> specification =
                super.applySearchFilter(criteria.getNome(), "nome")
                        .and(super.applyUUIDFilter(criteria.getProduttore(), "produttore"))
                        .and(super.applyUUIDFilter(criteria.getComune(), "comune"))
                        .and(super.applyUUIDFilter(criteria.getProvincia(), "provincia"));

        return specification;
    }
}
