package com.nbva.product.infrastructure.repository;

import com.nbva.product.api.dto.product.request.PageProductRequest;
import com.nbva.product.domain.entity.ProductEntity;

import java.util.List;

public interface JdbcProductRepository {
    List<ProductEntity> getProducts(PageProductRequest pageProductRequest);
}
