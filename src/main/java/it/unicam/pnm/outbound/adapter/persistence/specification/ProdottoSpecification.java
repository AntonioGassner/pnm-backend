package it.unicam.pnm.outbound.adapter.persistence.specification;

import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCriteria;
import it.unicam.pnm.outbound.adapter.persistence.entity.ProdottoEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProdottoSpecification extends AbstractSpecification<ProdottoEntity> {

    public Specification<ProdottoEntity> filter(ProdottoCriteria criteria){

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<ProdottoEntity> specification =
                super.applySearchFilter(criteria.getNome(), "nome")
                        .and(super.applySearchFilter(criteria.getNome(), "descrizione"));

        return specification;
    }

}
