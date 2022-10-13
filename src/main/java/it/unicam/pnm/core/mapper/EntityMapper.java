package it.unicam.pnm.core.mapper;

import java.util.List;

public interface EntityMapper<M, E> {

    M fromEntityToModel(E entity);

    E fromModelToEntity(M model);

    List<M> fromEntitiesToModels(List<E> entityList);

    List<E> fromModelsToEntities(List<M> modelList);

}
