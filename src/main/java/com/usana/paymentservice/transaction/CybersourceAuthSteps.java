package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.cybersource.CybersourceAuthRequest;
import com.usana.paymentservice.model.cybersource.CybersourceAuthResponse;
import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;

public class CybersourceAuthSteps implements TransactionSteps<CybersourceAuthResponse, CybersourceAuthRequest> {

   
    @Override
    public CybersourceAuthRequest buildRequest(ServiceRequest serviceRequest) {
        System.out.println("building CybersourceAuthRequest from service request.");
        return new CybersourceAuthRequest();
    }

    @Override
    public CybersourceAuthResponse sendRequest(CybersourceAuthRequest r) {
        System.out.println("sending CybersourceAuthRequest to Cybersource.");
        return new CybersourceAuthResponse();
    }

    @Override
    public ServiceResponse buildResponse(CybersourceAuthResponse t) {
        System.out.println("building ServiceResponse from CybersourceAuthResponse.");
        return new ServiceResponse();
    }

    @Override
    public void save(CybersourceAuthResponse t, CybersourceAuthRequest r) {
        System.out.println("saving transaction to DB");
    }
}