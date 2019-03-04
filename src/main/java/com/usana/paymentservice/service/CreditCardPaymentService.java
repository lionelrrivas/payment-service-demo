package com.usana.paymentservice.service;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public interface CreditCardPaymentService {
    
    ServiceResponse authorizePayment(ServiceRequest serviceRequest);
    ServiceResponse cancelPayment(ServiceRequest serviceRequest);
    ServiceResponse refundPayment(ServiceRequest serviceRequest);
}
