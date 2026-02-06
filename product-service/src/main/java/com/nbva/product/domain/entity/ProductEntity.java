package com.nbva.product.domain.entity;

import com.nbva.common.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "product")
@Entity
public class ProductEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
}
