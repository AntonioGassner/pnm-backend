package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria.AziendaCategoriaCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaCategoriaEntity;
import org.springframework.data.jpa.domain.Specification;

// TODO capire come trattare questi filtri di ricerca per UUID
//  dato che sul progetto mi ricordo che costruivamo dei filtri specifici quando cercavamo delle classi

public class AziendaCategoriaSpecification extends AbstractSpecification<AziendaCategoriaEntity> {

    public Specification<AziendaCategoriaEntity> filter(AziendaCategoriaCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<AziendaCategoriaEntity> specification =
                super.applyUUIDFilter(criteria.getAzienda(), "azienda")
                        .and(super.applyUUIDFilter(criteria.getCategoria(), "categoria"));

        return specification;
    }
}
