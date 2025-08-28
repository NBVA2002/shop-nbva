package com.nbva.product.infrastructure.repository;

import com.nbva.product.domain.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<PaymentEntity, String> {
}
