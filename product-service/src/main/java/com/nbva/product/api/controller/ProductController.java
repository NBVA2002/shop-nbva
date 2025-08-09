package com.nbva.product.api.controller;

import com.nbva.product.api.ProductAPI;
import com.nbva.product.api.dto.BaseResponse;
import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.api.dto.response.ProductListResponse;
import com.nbva.product.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class ProductController implements ProductAPI {

    private final ProductService productService;

    @Override
    public ResponseEntity<BaseResponse<List<ProductListResponse>>> getProducts(ProductListRequest productListRequest) {
        return ResponseEntity.ok(BaseResponse.success(productService.getProducts(productListRequest)));
    }

}
