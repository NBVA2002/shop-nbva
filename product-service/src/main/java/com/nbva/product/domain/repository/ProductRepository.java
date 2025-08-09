package com.nbva.product.domain.repository;

import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.domain.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    List<ProductEntity> getProducts(ProductListRequest productListRequest);
}
