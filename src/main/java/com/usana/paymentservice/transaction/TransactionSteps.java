package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public interface TransactionSteps<T, R> {
    R buildRequest(ServiceRequest serviceRequest);
    
    T sendRequest(R request);
    
    ServiceResponse buildResponse(T response);
    
    void save(T response, R request);
}