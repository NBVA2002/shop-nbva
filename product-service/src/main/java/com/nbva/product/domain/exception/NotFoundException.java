package com.nbva.product.domain.exception;

import com.nbva.common.base.BaseException;

public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(404, message);
    }
}
