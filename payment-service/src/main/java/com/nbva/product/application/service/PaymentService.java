package com.nbva.product.application.service;

import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.api.dto.response.ProductListResponse;
import com.nbva.product.domain.constant.PaymentMethod;

import java.util.List;

public interface PaymentService {
    List<ProductListResponse> getProducts(ProductListRequest productListRequest);
    void createPayment(PaymentMethod paymentMethod);
    PaymentMethod getPaymentMethod();
}
