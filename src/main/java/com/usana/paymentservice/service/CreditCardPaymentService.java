package com.usana.paymentservice.service;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public interface CreditCardPaymentService {
    
    public abstract ServiceResponse authorizePayment(ServiceRequest serviceRequest);
    public abstract ServiceResponse cancelPayment(ServiceRequest serviceRequest);
    public abstract ServiceResponse refundPayment(ServiceRequest serviceRequest);
}
