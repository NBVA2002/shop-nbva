package com.nbva.authenticate.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Types;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @UuidGenerator
    @JdbcTypeCode(Types.VARCHAR)
    @Column(name = "\"id\"")
    protected String id;
}
