package com.nbva.product.domain.entity;

import com.nbva.product.common.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "\"Product\"")
@Entity
public class PaymentEntity extends BaseEntity {
}
