package com.nbva.product.application.service.impl;

import com.nbva.common.dto.PageDTO;
import com.nbva.product.domain.entity.ProductEntity;
import com.nbva.product.presentation.dto.product.request.ProductPageRequest;
import com.nbva.product.presentation.dto.product.response.ProductPageDTO;
import com.nbva.product.application.service.ProductService;
import com.nbva.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public PageDTO<ProductPageDTO> getPageProduct(Pageable pageable, ProductPageRequest request) {
        Page<ProductEntity> productEntityPage = productRepository.getPageProduct(request);
        return new PageDTO<>();
    }
}
