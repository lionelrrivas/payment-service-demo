package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public abstract class Cancel<T, R> {
    
    protected TransactionSteps<T, R> transactionSteps; 
    
    public Cancel(TransactionSteps<T, R> transactionSteps) {
        this.transactionSteps = transactionSteps;
    }
    
    public abstract ServiceResponse cancel(ServiceRequest serviceRequest);
}
