package com.nbva.product.application.service;

import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.api.dto.response.ProductListResponse;

import java.util.List;

public interface ProductService {
    List<ProductListResponse> getProducts(ProductListRequest productListRequest);
}
