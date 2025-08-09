package com.nbva.product.application.mapper.impl;

import com.nbva.product.application.dto.BaseDTO;
import com.nbva.product.application.mapper.BaseMapper;
import com.nbva.product.domain.entity.BaseEntity;
import org.modelmapper.ModelMapper;

public abstract class AbstractBaseMapper<D extends BaseDTO, E extends BaseEntity> implements BaseMapper<D, E> {

    protected final ModelMapper modelMapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    public AbstractBaseMapper(ModelMapper modelMapper, Class<E> entityClass, Class<D> dtoClass) {
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public D entityToDTO(E entity) {
        return modelMapper.map(entity, dtoClass);
    }
}