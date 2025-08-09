package com.nbva.product.api;

import com.nbva.product.api.dto.BaseResponse;
import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.api.dto.response.ProductListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public interface ProductAPI {

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    ResponseEntity<BaseResponse<List<ProductListResponse>>> getProducts(ProductListRequest productListRequest);

}
