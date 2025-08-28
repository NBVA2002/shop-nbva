package com.nbva.product.api.controller;

import com.nbva.product.api.ProductAPI;
import com.nbva.product.api.dto.response.SuccessResponse;
import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.api.dto.response.ProductListResponse;
import com.nbva.product.application.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class ProductController implements ProductAPI {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<SuccessResponse<List<ProductListResponse>>> getProducts(ProductListRequest productListRequest) {
        return ResponseEntity.ok(new SuccessResponse<>(paymentService.getProducts(productListRequest)));
    }

}
