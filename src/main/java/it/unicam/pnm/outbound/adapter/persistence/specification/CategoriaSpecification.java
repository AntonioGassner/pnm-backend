package it.unicam.pnm.outbound.adapter.persistence.specification;


import it.unicam.pnm.outbound.adapter.persistence.entity.CategoriaEntity;
import org.springframework.data.jpa.domain.Specification;

public class CategoriaSpecification extends AbstractSpecification<CategoriaEntity> {

    public Specification<CategoriaEntity> filter(it.unicam.pnm.inbound.adapter.rest.dto.categoria.CategoriaCriteria criteria) {

//        String flagName = "flagElimina";
//        boolean flagValue = false;

        Specification<CategoriaEntity> specification =
                super.applySearchFilter(criteria.getNome(), "nome");
        return specification;
    }

}
