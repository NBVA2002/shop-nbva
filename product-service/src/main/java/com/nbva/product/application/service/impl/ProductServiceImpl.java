package com.nbva.product.application.service.impl;

import com.nbva.common.dto.PageResponse;
import com.nbva.product.api.dto.product.request.PageProductRequest;
import com.nbva.product.api.dto.product.response.ProductPageResponse;
import com.nbva.product.application.mapper.ProductMapper;
import com.nbva.product.application.service.ProductService;
import com.nbva.product.domain.entity.ProductEntity;
import com.nbva.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public PageResponse<ProductPageResponse> getPageProduct(PageProductRequest pageProductRequest) {
        Page<ProductEntity> productEntityPage = productRepository.getPageProduct(pageProductRequest);
        return new PageResponse<>(productEntityPage, productMapper::toProductPageResponse);
    }
}
