package com.nbva.product.infrastructure.repository;

import com.nbva.product.presentation.dto.product.request.ProductPageRequest;
import com.nbva.product.domain.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface JpaProductCustomRepository {
    Page<ProductEntity> getPageProduct(ProductPageRequest productPageRequest);
}
