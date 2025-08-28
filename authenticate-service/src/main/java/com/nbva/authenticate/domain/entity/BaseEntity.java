package com.nbva.authenticate.domain.entity;

import com.nbva.authenticate.infrastructure.dto.UserInfo;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.Types;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @UuidGenerator
    @JdbcTypeCode(Types.VARCHAR)
    @Column(name = "\"id\"")
    protected String id;

    @Column(name = "\"createdBy\"")
    protected String createdBy;

    @Column(name = "\"createdDate\"")
    protected Date createdDate;

    @Column(name = "\"updatedBy\"")
    protected String updatedBy;

    @Column(name = "\"updatedDate\"")
    protected Date updatedDate;

    @Version
    @Column(name = "\"version\"")
    protected Integer version;

    @Column(name = "\"isDeleted\"")
    protected Boolean isDeleted = false;

    @PrePersist
    protected void onCreate() {
        this.createdDate = new Date();
        this.createdBy = getCurrentUser();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = new Date();
        this.updatedBy = getCurrentUser();
    }

    private String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        } else {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserInfo userInfo) {
                return userInfo.getId();
            } else {
                return null;
            }
        }
    }
}
