package com.nbva.product.api;

import com.nbva.common.dto.PageResponse;
import com.nbva.product.api.dto.product.request.CreateProductRequest;
import com.nbva.product.api.dto.product.response.ProductDetailResponse;
import com.nbva.product.common.dto.response.SuccessResponse;
import com.nbva.product.api.dto.product.request.PageProductRequest;
import com.nbva.product.api.dto.product.response.ProductPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
public interface ProductAPI {

    @GetMapping("/page/public")
    ResponseEntity<SuccessResponse<PageResponse<ProductPageResponse>>> getPageProduct(
        PageProductRequest pageProductRequest);

    @GetMapping("/{id}")
    ResponseEntity<SuccessResponse<ProductDetailResponse>> getDetailProduct(@PathVariable String id);

    @PostMapping
    ResponseEntity<SuccessResponse<Page<ProductPageResponse>>> createProduct(
        CreateProductRequest createProductRequest);

}
