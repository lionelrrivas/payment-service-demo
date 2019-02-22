/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usana.paymentservice.processor;

import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.transaction.TransactionSteps;

/**
 *
 * @author lionelrivas
 */
public interface AlternativePaymentProcessor {
    
    <X extends TransactionSteps> ServiceResponse processTransaction(X x);
}
