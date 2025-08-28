package com.nbva.product.domain.repository.impl;

import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.domain.entity.PaymentEntity;
import com.nbva.product.domain.repository.ProductRepository;
import com.nbva.product.infrastructure.repository.JdbcProductRepository;
import com.nbva.product.infrastructure.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final JdbcProductRepository jdbcProductRepository;

    @Override
    public List<PaymentEntity> getProducts(ProductListRequest productListRequest) {
        return jdbcProductRepository.getProducts(productListRequest);
    }
}
