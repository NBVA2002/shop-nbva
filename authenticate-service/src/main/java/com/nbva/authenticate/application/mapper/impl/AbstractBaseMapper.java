package com.nbva.authenticate.application.mapper.impl;

import com.nbva.authenticate.application.dto.BaseDTO;
import com.nbva.authenticate.application.mapper.BaseMapper;
import com.nbva.common.base.BaseEntity;
import org.modelmapper.ModelMapper;

public abstract class AbstractBaseMapper<D extends BaseDTO, E extends BaseEntity> implements BaseMapper<D, E> {

    protected final ModelMapper modelMapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    protected AbstractBaseMapper(ModelMapper modelMapper, Class<D> dtoClass, Class<E> entityClass) {
        this.modelMapper = modelMapper;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    @Override
    public D entityToDTO(E entity) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public E dtoToEntity(D dto) {
        return modelMapper.map(dto, entityClass);
    }
}