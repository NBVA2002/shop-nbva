package com.nbva.common.base;

import java.util.List;

public interface BaseMapper<D extends BaseDTO, E extends BaseEntity> {

    E toEntity(D dto);

    List<E> toEntity(List<D> dtos);

    D toDTO(E entity);

    List<D> toDTO(List<E> entities);

}