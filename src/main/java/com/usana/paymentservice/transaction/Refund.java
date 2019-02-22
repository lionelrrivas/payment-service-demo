package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public abstract class Refund<T, R> {
    
    protected TransactionSteps<T, R> transactionSteps; 

    public Refund(TransactionSteps<T, R> transactionSteps) {
        this.transactionSteps = transactionSteps;
    }
    
    public abstract ServiceResponse refund(ServiceRequest serviceRequest);
}
