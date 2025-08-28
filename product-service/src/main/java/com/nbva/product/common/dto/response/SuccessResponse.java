package com.nbva.product.common.dto.response;

import com.nbva.product.common.base.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class SuccessResponse<T> extends BaseResponse {
    private T data;

    public SuccessResponse(T data) {
        super(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        this.data = data;
    }

}
