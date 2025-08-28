package com.nbva.product.application.mapper;

import com.nbva.product.api.dto.product.response.ProductPageResponse;
import com.nbva.product.application.dto.ProductDTO;
import com.nbva.product.common.base.BaseMapper;
import com.nbva.product.domain.entity.ProductEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends BaseMapper<ProductDTO, ProductEntity> {

    public ProductMapper(ModelMapper modelMapper) {
        super(modelMapper);
    }

    public ProductPageResponse toProductPageResponse(ProductEntity entity) {
        return modelMapper.map(entity, ProductPageResponse.class);
    }

}
