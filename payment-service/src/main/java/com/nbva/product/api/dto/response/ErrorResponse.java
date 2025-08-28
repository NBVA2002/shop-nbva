package com.nbva.product.api.dto.response;

import com.nbva.product.common.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorResponse extends BaseResponse {
    private LocalDateTime timeStamp;

    public ErrorResponse(int status, String message) {
        super(status, message);
        this.timeStamp = LocalDateTime.now();
    }
}
