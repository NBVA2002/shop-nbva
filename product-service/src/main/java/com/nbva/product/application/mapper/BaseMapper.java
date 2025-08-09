package com.nbva.product.application.mapper;

import com.nbva.product.application.dto.BaseDTO;
import com.nbva.product.domain.entity.BaseEntity;

public interface BaseMapper<D extends BaseDTO, E extends BaseEntity> {
    D entityToDTO(E entity);
}
