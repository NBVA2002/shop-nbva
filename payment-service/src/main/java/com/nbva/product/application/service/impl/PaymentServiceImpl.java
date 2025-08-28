package com.nbva.product.application.service.impl;

import com.nbva.product.api.dto.request.ProductListRequest;
import com.nbva.product.api.dto.response.ProductListResponse;
import com.nbva.product.application.mapper.ProductMapper;
import com.nbva.product.application.service.PaymentService;
import com.nbva.product.domain.constant.PaymentMethod;
import com.nbva.product.domain.entity.PaymentEntity;
import com.nbva.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductListResponse> getProducts(ProductListRequest productListRequest) {
        List<PaymentEntity> productEntities = productRepository.getProducts(productListRequest);
        return productEntities.stream().map(productMapper::entityToProductListResponse).collect(Collectors.toList());
    }

    @Override
    public void createPayment(PaymentMethod paymentMethod) {

    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.CREDIT_CARD;
    }
}
