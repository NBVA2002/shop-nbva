package com.nbva.product.api.controller;

import com.nbva.common.dto.PageResponse;
import com.nbva.product.api.ProductAPI;
import com.nbva.product.api.dto.product.request.CreateProductRequest;
import com.nbva.product.api.dto.product.response.ProductDetailResponse;
import com.nbva.product.common.dto.response.SuccessResponse;
import com.nbva.product.api.dto.product.request.PageProductRequest;
import com.nbva.product.api.dto.product.response.ProductPageResponse;
import com.nbva.product.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductController implements ProductAPI {

    private final ProductService productService;

    @Override
    public ResponseEntity<SuccessResponse<PageResponse<ProductPageResponse>>> getPageProduct(PageProductRequest pageProductRequest) {
        return ResponseEntity.ok(new SuccessResponse<>(productService.getPageProduct(pageProductRequest)));
    }

    @Override
    public ResponseEntity<SuccessResponse<ProductDetailResponse>> getDetailProduct(String id) {
        return null;
    }

    @Override
    public ResponseEntity<SuccessResponse<Page<ProductPageResponse>>> createProduct(
        CreateProductRequest createProductRequest) {
        return null;
    }


}
