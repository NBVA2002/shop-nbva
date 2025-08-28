package com.nbva.product.infrastructure.repository;

import com.nbva.product.api.dto.product.request.PageProductRequest;
import com.nbva.product.domain.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface JpaProductCustomRepository {
    Page<ProductEntity> getPageProduct(PageProductRequest pageProductRequest);
}
