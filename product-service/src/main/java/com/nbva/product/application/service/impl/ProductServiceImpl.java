package com.nbva.product.application.service.impl;

import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.api.dto.response.ProductListResponse;
import com.nbva.product.application.mapper.impl.ProductMapper;
import com.nbva.product.application.service.ProductService;
import com.nbva.product.domain.entity.ProductEntity;
import com.nbva.product.domain.repository.ProductRepository;
import com.nbva.product.infrastructure.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final UserInfo userInfo;

    @Override
    public List<ProductListResponse> getProducts(ProductListRequest productListRequest) {
        List<ProductEntity> productEntities = productRepository.getProducts(productListRequest);
        return productEntities.stream().map(productMapper::entityToProductListResponse).collect(Collectors.toList());
    }
}
