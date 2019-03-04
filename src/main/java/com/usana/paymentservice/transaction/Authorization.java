package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public abstract class Authorization<T, R> {
    
    protected TransactionSteps<T, R> transactionSteps; 

    public Authorization(TransactionSteps<T, R> transactionSteps) {
        this.transactionSteps = transactionSteps;
    }
    
    public abstract ServiceResponse authorize(ServiceRequest serviceRequest);
}
