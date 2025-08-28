package com.nbva.common.base;

import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseMapper<D extends BaseDTO, E extends BaseEntity> {

    protected final ModelMapper modelMapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    @SuppressWarnings("unchecked")
    protected BaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.dtoClass = (Class<D>) type.getActualTypeArguments()[0];
        this.entityClass = (Class<E>) type.getActualTypeArguments()[1];
    }

    public E toEntity(D dto) {
        return modelMapper.map(dto, entityClass);
    }

    public List<E> toEntity(List<D> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public D toDTO(E entity) {
        return modelMapper.map(entity, dtoClass);
    }

    public List<D> toDTO(List<E> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }

}