package com.usana.paymentservice.service;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.processor.CreditCardPaymentProcessor;

public class CyberSourcePaymentService implements CreditCardPaymentService {

    CreditCardPaymentProcessor paymentProcessor;

    public CyberSourcePaymentService(CreditCardPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    
    @Override
    public ServiceResponse authorizePayment(ServiceRequest serviceRequest) {
        return paymentProcessor.authorizePayment(serviceRequest);
    }

    @Override
    public ServiceResponse cancelPayment(ServiceRequest serviceRequest) {
        return paymentProcessor.cancelPayment(serviceRequest);
    }

    @Override
    public ServiceResponse refundPayment(ServiceRequest serviceRequest) {
        return paymentProcessor.refundPayment(serviceRequest);
    }
}