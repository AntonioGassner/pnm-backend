package it.unicam.pnm.outbound.adapter.persistence.specification;


import it.unicam.pnm.outbound.adapter.persistence.entity.TipoProdottoEntity;
import org.springframework.data.jpa.domain.Specification;

public class TipoProdottoSpecification extends AbstractSpecification<TipoProdottoEntity> {

    public Specification<TipoProdottoEntity> filter(it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCriteria criteria){

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<TipoProdottoEntity> specification =
                super.applySearchFilter(criteria.getNome(), "nome")
                        .and(super.applySearchFilter(criteria.getNome(), "descrizione"));

        return specification;
    }

}
