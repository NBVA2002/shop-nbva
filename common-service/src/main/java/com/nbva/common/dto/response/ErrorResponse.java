package com.nbva.common.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nbva.common.base.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorResponse extends BaseResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeStamp;

    public ErrorResponse(int status, String message) {
        super(status, message);
        this.timeStamp = LocalDateTime.now();
    }
}
