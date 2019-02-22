package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public interface TransactionSteps<T, R> {
    R buildRequest(ServiceRequest serviceRequest);
    
    T sendRequest(R r);
    
    ServiceResponse buildResponse(T t);
    
    void save(T t, R r);
}