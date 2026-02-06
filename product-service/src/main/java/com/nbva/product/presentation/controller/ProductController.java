package com.nbva.product.presentation.controller;

import com.nbva.common.base.BaseResponse;
import com.nbva.common.dto.PageDTO;
import com.nbva.common.dto.response.SuccessResponse;
import com.nbva.product.presentation.dto.product.request.CreateProductRequest;
import com.nbva.product.presentation.dto.product.response.ProductDetailResponse;
import com.nbva.product.presentation.dto.product.request.ProductPageRequest;
import com.nbva.product.presentation.dto.product.response.ProductPageDTO;
import com.nbva.product.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/page")
    public ResponseEntity<BaseResponse> getPageProduct(Pageable pageable, ProductPageRequest request) {
        return ResponseEntity.ok(new SuccessResponse<>(productService.getPageProduct(pageable, request)));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<BaseResponse> getDetailProduct(@PathVariable("id") String id) {
        return null;
    }

    public ResponseEntity<BaseResponse> createProduct(
        CreateProductRequest createProductRequest) {
        return null;
    }

}
