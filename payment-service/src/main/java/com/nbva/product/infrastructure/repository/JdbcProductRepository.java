package com.nbva.product.infrastructure.repository;

import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.domain.entity.PaymentEntity;

import java.util.List;

public interface JdbcProductRepository {
    List<PaymentEntity> getProducts(ProductListRequest productListRequest);
}
