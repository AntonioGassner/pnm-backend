package it.unicam.pnm.outbound.adapter.persistence.specification;

import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class AbstractSpecification<ENTITY> extends QueryService<ENTITY> {

    protected Specification<ENTITY> applyEqualsFilter(Filter<? extends Serializable> filter, String fieldName) {
        return this.buildSpecification(filter, root -> root.get(fieldName));
    }

    protected <ENTITY1, ENTITY2> Specification<ENTITY> applyJoinInFilterGeneric(List<UUID> list, String fieldName,
                                                                                Join<ENTITY1, ENTITY2> join) {
        Specification<ENTITY> specification = Specification.where(null);
        if (!list.isEmpty()) {
            UUIDFilter filter = new UUIDFilter();
            filter.setIn(new ArrayList<>(list));
            specification = specification.or(buildSpecification(filter, root -> join.get(fieldName)));
        }
        return specification;
    }

    protected Specification<ENTITY> applyUUIDFilter(List<UUID> list, String fieldName) {
        Specification<ENTITY> specification = Specification.where(null);
        if (!list.isEmpty()) {
            UUIDFilter filter = new UUIDFilter();
            filter.setIn(list);
            specification = specification.or(buildSpecification(filter, root -> root.get(fieldName)));
        }
        return specification;
    }

    protected Specification<ENTITY> flagSpecification(String flagName, boolean flagValue) {
        return (grp, query, cb) -> cb.equal(grp.<Short>get(flagName), flagValue);
    }

    protected Specification<ENTITY> applyIntegerFilter(List<Integer> list, String fieldName) {
        Specification<ENTITY> specification = Specification.where(null);
        if (!list.isEmpty()) {
            IntegerFilter filter = new IntegerFilter();
            filter.setIn(list);
            specification = specification.or(buildSpecification(filter, root -> root.get(fieldName)));
        }
        return specification;
    }

    protected Specification<ENTITY> applyShortFilter(List<Short> list, String fieldName) {
        Specification<ENTITY> specification = Specification.where(null);
        if (!list.isEmpty()) {
            ShortFilter filter = new ShortFilter();
            filter.setIn(list);
            specification = specification.or(buildSpecification(filter, root -> root.get(fieldName)));
        }
        return specification;
    }

    protected Specification<ENTITY> applySearchFilter(List<StringFilter> request, String fieldName) {
        return this.applySearchFilter(request, fieldName, Collections.emptyList());
    }

    protected Specification<ENTITY> applySearchFilter(List<StringFilter> request, String fieldName,
                                                      List<String> reference) {
        Specification<ENTITY> specification = Specification.where(null);
        if (request != null && !request.isEmpty()) {
            for (StringFilter current : request) {
                if (!reference.isEmpty()) {
                    specification = specification
                            .or(buildSpecification(current, root -> this.evaluatePath(root, reference).get(fieldName)));
                } else {
                    specification = specification.or(buildSpecification(current, root -> root.get(fieldName)));
                }
            }
        }
        return specification;
    }

    private Path<?> evaluatePath(Root<ENTITY> root, List<String> references) {
        Path<?> calc = root.get(references.get(0));
        for (String r : references.subList(1, references.size())) {
            calc = calc.get(r);
        }
        return calc;
    }

    protected <ENTITY1, ENTITY2> Specification<ENTITY> applyJoinInFilter(List<UUID> list, String fieldName,
                                                                         Join<ENTITY1, ENTITY2> join) {
        Specification<ENTITY> specification = Specification.where(null);
        if (!list.isEmpty()) {
            UUIDFilter filter = new UUIDFilter();
            filter.setIn(new ArrayList<>(list));
            specification = specification.or(buildSpecification(filter, root -> join.get(fieldName)));
        }
        return specification;
    }
}

