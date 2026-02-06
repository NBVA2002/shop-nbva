package com.nbva.authenticate.application.mapper;

import com.nbva.authenticate.application.dto.BaseDTO;
import com.nbva.common.base.BaseEntity;

public interface BaseMapper<D extends BaseDTO, E extends BaseEntity> {
    D entityToDTO(E entity);
    E dtoToEntity(D dto);
}
