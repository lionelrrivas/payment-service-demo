/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

/**
 *
 * @author lionelrivas
 * @param <T>
 * @param <R>
 */
public abstract class Cancel<T, R> {
    
    protected TransactionSteps<T, R> transactionSteps; 
    
    public Cancel(TransactionSteps<T, R> transactionSteps) {
        this.transactionSteps = transactionSteps;
    }
    
    public abstract ServiceResponse cancel(ServiceRequest serviceRequest);
}
