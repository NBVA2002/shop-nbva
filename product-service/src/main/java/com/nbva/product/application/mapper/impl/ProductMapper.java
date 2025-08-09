package com.nbva.product.application.mapper.impl;

import com.nbva.product.api.dto.response.ProductListResponse;
import com.nbva.product.application.dto.ProductDTO;
import com.nbva.product.application.mapper.BaseMapper;
import com.nbva.product.domain.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends AbstractBaseMapper<ProductDTO, ProductEntity> implements BaseMapper<ProductDTO, ProductEntity> {

    public ProductMapper(ModelMapper modelMapper) {
        super(modelMapper, ProductEntity.class, ProductDTO.class);
    }

    public ProductListResponse entityToProductListResponse(ProductEntity entity) {
        return modelMapper.map(entity, ProductListResponse.class);
    }
}
