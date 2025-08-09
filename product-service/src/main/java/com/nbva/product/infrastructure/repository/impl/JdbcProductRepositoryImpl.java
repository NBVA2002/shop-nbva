package com.nbva.product.infrastructure.repository.impl;

import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.domain.entity.ProductEntity;
import com.nbva.product.infrastructure.repository.JdbcProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcProductRepositoryImpl implements JdbcProductRepository {

    @Override
    public List<ProductEntity> getProducts(ProductListRequest productListRequest) {
        return List.of();
    }
}
