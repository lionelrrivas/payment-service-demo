package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.model.cybersource.CybersourceCancelRequest;
import com.usana.paymentservice.model.cybersource.CybersourceCancelResponse;

public class CybersourceCancel extends Cancel<CybersourceCancelResponse, CybersourceCancelRequest> {

    public CybersourceCancel(TransactionSteps<CybersourceCancelResponse, CybersourceCancelRequest> cancelTransaction) {
        super(cancelTransaction);
    }
    
    @Override
    public ServiceResponse cancel(ServiceRequest serviceRequest) {
        CybersourceCancelRequest cancelRequest = transactionSteps.buildRequest(serviceRequest);
        CybersourceCancelResponse cancelResponse = transactionSteps.sendRequest(cancelRequest);
        ServiceResponse serviceResponse = transactionSteps.buildResponse(cancelResponse);
        transactionSteps.save(cancelResponse, cancelRequest);
        return serviceResponse;
    }
}