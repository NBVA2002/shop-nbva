package com.nbva.product.domain.repository;

import com.nbva.product.api.dto.product.request.PageProductRequest;
import com.nbva.product.domain.entity.ProductEntity;

import java.util.List;
import org.springframework.data.domain.Page;

public interface ProductRepository {
    Page<ProductEntity> getPageProduct(PageProductRequest pageProductRequest);
    List<ProductEntity> getListProduct(PageProductRequest pageProductRequest);
}
