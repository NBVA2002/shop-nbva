package com.nbva.product.infrastructure.repository;

import com.nbva.product.application.dto.ProductDTO;
import com.nbva.product.domain.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface JpaProductRepository extends JpaRepository<ProductEntity, String>, JpaSpecificationExecutor<ProductEntity> {

    @Query(value = "SELECT p FROM ProductEntity p",
            countQuery = "SELECT count(*) FROM ProductEntity")
    Page<ProductEntity> getById(Pageable pageable);

    @Query(value = "SELECT new com.nbva.product.application.dto.ProductDTO(p.name) FROM ProductEntity p",
        countQuery = "SELECT count(p) FROM ProductEntity p")
    Page<ProductDTO> getProducts(Pageable pageable);
}
