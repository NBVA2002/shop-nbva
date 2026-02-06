package com.nbva.product.infrastructure.repository;

import com.nbva.product.presentation.dto.product.request.ProductPageRequest;
import com.nbva.product.domain.entity.ProductEntity;

import java.util.List;

public interface JdbcProductRepository {
    List<ProductEntity> getProducts(ProductPageRequest productPageRequest);
}
