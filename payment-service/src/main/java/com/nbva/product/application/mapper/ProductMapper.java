package com.nbva.product.application.mapper;

import com.nbva.product.api.dto.response.ProductListResponse;
import com.nbva.product.application.dto.ProductDTO;
import com.nbva.product.common.base.BaseMapper;
import com.nbva.product.domain.entity.PaymentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends BaseMapper<ProductDTO, PaymentEntity> {

    public ProductMapper(ModelMapper modelMapper) {
        super(modelMapper);
    }

    public ProductListResponse entityToProductListResponse(PaymentEntity entity) {
        return modelMapper.map(entity, ProductListResponse.class);
    }
}
