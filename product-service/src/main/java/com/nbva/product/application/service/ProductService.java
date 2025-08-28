package com.nbva.product.application.service;

import com.nbva.common.dto.PageResponse;
import com.nbva.product.api.dto.product.request.PageProductRequest;
import com.nbva.product.api.dto.product.response.ProductPageResponse;

public interface ProductService {
    PageResponse<ProductPageResponse> getPageProduct(PageProductRequest pageProductRequest);
}
