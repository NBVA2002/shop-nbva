package com.nbva.product.application.service;

import com.nbva.common.dto.PageDTO;
import com.nbva.product.presentation.dto.product.request.ProductPageRequest;
import com.nbva.product.presentation.dto.product.response.ProductPageDTO;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    PageDTO<ProductPageDTO> getPageProduct(Pageable pageable, ProductPageRequest request);
}
