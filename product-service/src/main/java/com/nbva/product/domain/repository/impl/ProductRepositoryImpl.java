package com.nbva.product.domain.repository.impl;

import com.nbva.product.api.dto.product.request.PageProductRequest;
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
    public Page<ProductEntity> getPageProduct(PageProductRequest pageProductRequest) {
        return jpaProductCustomRepository.getPageProduct(pageProductRequest);
    }

    @Override
    public List<ProductEntity> getListProduct(PageProductRequest pageProductRequest) {
        return jdbcProductRepository.getProducts(pageProductRequest);
    }

}
