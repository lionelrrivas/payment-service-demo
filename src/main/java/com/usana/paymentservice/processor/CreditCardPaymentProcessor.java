/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usana.paymentservice.processor;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

/**
 *
 * @author lionelrivas
 */
public interface CreditCardPaymentProcessor {
    
    ServiceResponse authorizePayment(ServiceRequest serviceRequest);
    ServiceResponse refundPayment(ServiceRequest serviceRequest);
    ServiceResponse cancelPayment(ServiceRequest serviceRequest);
    
}
