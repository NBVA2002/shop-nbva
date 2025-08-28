package com.nbva.product.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentMethod {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    PAYPAL("PayPal"),
    BANK_TRANSFER("Bank Transfer"),
    CASH_ON_DELIVERY("Cash on Delivery");

    private final String displayName;

}
