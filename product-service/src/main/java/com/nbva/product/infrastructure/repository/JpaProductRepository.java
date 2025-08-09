package com.nbva.product.infrastructure.repository;

import com.nbva.product.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, String> {
}
