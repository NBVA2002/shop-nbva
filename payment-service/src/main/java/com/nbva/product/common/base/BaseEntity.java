package com.nbva.product.common.base;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @Column(name = "\"id\"")
    protected String id;
}
