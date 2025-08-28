package com.nbva.product.common.base;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @Column(name = "\"id\"", length = 36)
    protected String id;

    @Column(name = "\"createdDate\"")
    private LocalDateTime createdDate;

    @Column(name = "\"updatedDate\"")
    private LocalDateTime updatedDate;

    @Column(name = "\"createdUser\"", length = 36)
    private String createdUser;

    @Column(name = "\"updatedUser\"", length = 36)
    private String updatedUser;

    @Version
    @Column(name = "\"version\"")
    private Integer version;

    @Column(name = "\"isDel\"")
    private Boolean isDel;

}
