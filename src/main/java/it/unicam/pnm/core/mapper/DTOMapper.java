package it.unicam.pnm.core.mapper;

import java.util.List;

public interface DTOMapper<D, E> {

    E toModel(D dto);

    D toDto(E entity);

    List<E> toModel(List<D> dtoList);

    List<D> toDto(List<E> entityList);

}
