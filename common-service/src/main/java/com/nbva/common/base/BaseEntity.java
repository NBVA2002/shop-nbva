package com.nbva.common.base;

import com.nbva.common.dto.CurrentUserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

    @PrePersist
    protected void onCreate() {
        if (this.createdDate == null) {
            this.createdDate = LocalDateTime.now();
        }

        this.setCreatedUser(this.getCurrentUserId());
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
        this.setUpdatedUser(this.getCurrentUserId());
    }

    private String getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        } else {
            Object principal = authentication.getPrincipal();
            if (principal instanceof CurrentUserDTO jwtUser) {
                return jwtUser.getId();
            } else {
                return null;
            }
        }
    }
}
