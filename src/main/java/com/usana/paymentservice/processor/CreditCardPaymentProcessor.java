package com.usana.paymentservice.processor;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public interface CreditCardPaymentProcessor {
    
    ServiceResponse authorizePayment(ServiceRequest serviceRequest);
    ServiceResponse refundPayment(ServiceRequest serviceRequest);
    ServiceResponse cancelPayment(ServiceRequest serviceRequest);
    
}
