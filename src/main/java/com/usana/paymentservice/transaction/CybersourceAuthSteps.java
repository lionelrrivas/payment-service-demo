package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.cybersource.CybersourceAuthRequest;
import com.usana.paymentservice.model.cybersource.CybersourceAuthResponse;
import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.transformer.amex.CybersourceTransformers;

public class CybersourceAuthSteps implements TransactionSteps<CybersourceAuthResponse, CybersourceAuthRequest> {
    
    @Override
    public CybersourceAuthRequest buildRequest(ServiceRequest serviceRequest) {
        System.out.println("building CybersourceAuthRequest from service request.");
        CybersourceAuthRequest authRequest = CybersourceTransformers
                .authRequestTransformer()
                .apply(serviceRequest);
        System.out.println("setting merchantId");
        authRequest.setMerchantId("123456789");
        return authRequest;
    }

    @Override
    public CybersourceAuthResponse sendRequest(CybersourceAuthRequest authRequest) {
        System.out.println("sending CybersourceAuthRequest to Cybersource.");
        CybersourceAuthResponse authResponse = new CybersourceAuthResponse();
        authResponse.setOrderId(authRequest.getOrderId());
        authResponse.setStatusCode("APPROVED");
        return authResponse;
    }

    @Override
    public ServiceResponse buildResponse(CybersourceAuthResponse authResponse) {
        System.out.println("building ServiceResponse from CybersourceAuthResponse.");
        ServiceResponse serviceResponse = CybersourceTransformers
                .authResponseTransformer()
                .apply(authResponse);
        return serviceResponse;
    }

    @Override
    public void save(CybersourceAuthResponse authResponse, CybersourceAuthRequest authRequest) {
        System.out.println("saving transaction to DB");
    }
}