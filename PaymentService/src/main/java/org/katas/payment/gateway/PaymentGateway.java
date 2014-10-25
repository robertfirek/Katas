package org.katas.payment.gateway;

public interface PaymentGateway {
    void process(PaymentDetails paymentDetails);
}
