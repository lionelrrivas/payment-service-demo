package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.model.cybersource.CybersourceAuthRequest;
import com.usana.paymentservice.model.cybersource.CybersourceAuthResponse;

public class CybersourceAuthorization extends Authorization<CybersourceAuthResponse, CybersourceAuthRequest> {

    public CybersourceAuthorization(TransactionSteps<CybersourceAuthResponse, CybersourceAuthRequest> transaction) {
        super(transaction);
    }
    
    @Override
    public ServiceResponse authorize(ServiceRequest serviceRequest) {
        CybersourceAuthRequest authRequest = transactionSteps.buildRequest(serviceRequest);
        CybersourceAuthResponse authResponse = transactionSteps.sendRequest(authRequest);
        ServiceResponse serviceResponse = transactionSteps.buildResponse(authResponse);
        transactionSteps.save(authResponse, authRequest);
        return serviceResponse;
    }
}