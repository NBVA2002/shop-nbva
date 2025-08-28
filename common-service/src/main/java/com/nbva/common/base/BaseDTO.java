package com.nbva.common.base;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseDTO {
    protected String id;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String createdUser;

    private String updatedUser;

    private Integer version;

    private Boolean isDel;
}
