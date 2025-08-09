package com.nbva.product.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "\"Product\"")
@Entity
public class ProductEntity extends BaseEntity {
    private String name;
}
