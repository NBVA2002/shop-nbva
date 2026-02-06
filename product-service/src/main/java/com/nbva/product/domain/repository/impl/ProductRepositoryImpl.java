package com.nbva.product.domain.repository.impl;

import com.nbva.product.presentation.dto.product.request.ProductPageRequest;
import com.nbva.product.domain.entity.ProductEntity;
import com.nbva.product.domain.repository.ProductRepository;
import com.nbva.product.infrastructure.repository.JdbcProductRepository;
import com.nbva.product.infrastructure.repository.JpaProductCustomRepository;
import com.nbva.product.infrastructure.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final JpaProductCustomRepository jpaProductCustomRepository;
    private final JdbcProductRepository jdbcProductRepository;

    @Override
    public Page<ProductEntity> getPageProduct(ProductPageRequest productPageRequest) {
        return jpaProductCustomRepository.getPageProduct(productPageRequest);
    }

    @Override
    public List<ProductEntity> getListProduct(ProductPageRequest productPageRequest) {
        return jdbcProductRepository.getProducts(productPageRequest);
    }

}
