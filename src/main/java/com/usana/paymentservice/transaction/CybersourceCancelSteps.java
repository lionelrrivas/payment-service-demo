package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.cybersource.CybersourceCancelRequest;
import com.usana.paymentservice.model.cybersource.CybersourceCancelResponse;
import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public class CybersourceCancelSteps implements TransactionSteps<CybersourceCancelResponse, CybersourceCancelRequest> {

    @Override
    public CybersourceCancelRequest buildRequest(ServiceRequest serviceRequest) {
        System.out.println("building CybersourceCancelRequest from service request.");
        return new CybersourceCancelRequest();
    }

    @Override
    public CybersourceCancelResponse sendRequest(CybersourceCancelRequest r) {
        System.out.println("sending CybersourceCancelRequest to Cybersource.");
        return new CybersourceCancelResponse();
    }

    @Override
    public ServiceResponse buildResponse(CybersourceCancelResponse t) {
        System.out.println("building ServiceResponse from CybersourceCancelResponse.");
        return new ServiceResponse();
    }

    @Override
    public void save(CybersourceCancelResponse t, CybersourceCancelRequest r) {
        System.out.println("saving transaction to DB");
    }
}