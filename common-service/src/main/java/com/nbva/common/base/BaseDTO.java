package com.nbva.common.base;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
public class BaseDTO {
    String id;

    LocalDateTime createdDate;

    LocalDateTime updatedDate;

    String createdUser;

    String updatedUser;

    Integer version;

    Boolean isDel;
}
