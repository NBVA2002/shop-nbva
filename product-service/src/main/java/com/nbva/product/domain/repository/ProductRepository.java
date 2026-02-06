package com.nbva.product.domain.repository;

import com.nbva.product.presentation.dto.product.request.ProductPageRequest;
import com.nbva.product.domain.entity.ProductEntity;

import java.util.List;
import org.springframework.data.domain.Page;

public interface ProductRepository {
    Page<ProductEntity> getPageProduct(ProductPageRequest productPageRequest);
    List<ProductEntity> getListProduct(ProductPageRequest productPageRequest);
}
