package com.nbva.product.application.service.impl;

import com.nbva.product.application.service.PaymentService;
import com.nbva.product.domain.constant.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentFactory {

    private final Map<PaymentMethod, PaymentService> serviceMap = new EnumMap<>(PaymentMethod.class);

    public PaymentFactory(List<PaymentService> services) {
        services.forEach(service -> serviceMap.put(service.getPaymentMethod(), service));
    }

    public PaymentService getService(PaymentMethod method) {
        PaymentService service = serviceMap.get(method);
        if (service == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + method);
        }
        return service;
    }
}