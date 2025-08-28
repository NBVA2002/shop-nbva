package com.nbva.common.dto.response;

import com.nbva.common.base.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class SuccessResponse<T> extends BaseResponse {
    private T data;

    public SuccessResponse(T data) {
        super(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        this.data = data;
    }

}
