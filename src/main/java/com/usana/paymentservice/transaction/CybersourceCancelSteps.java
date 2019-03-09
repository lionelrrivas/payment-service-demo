package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.cybersource.CybersourceCancelRequest;
import com.usana.paymentservice.model.cybersource.CybersourceCancelResponse;
import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.transformer.cybersource.CybersourceTransformers;

public class CybersourceCancelSteps implements TransactionSteps<CybersourceCancelResponse, CybersourceCancelRequest> {

    @Override
    public CybersourceCancelRequest buildRequest(ServiceRequest serviceRequest) {
        System.out.println("building CybersourceCancelRequest from service request.");
        CybersourceCancelRequest cancelRequest = CybersourceTransformers.cancelRequestTransformer().apply(serviceRequest);
        return cancelRequest;
    }

    @Override
    public CybersourceCancelResponse sendRequest(CybersourceCancelRequest cancelRequest) {
        System.out.print("sending CybersourceCancelRequest to Cybersource.");
        System.out.println(" cancelRequest = " + cancelRequest);
        CybersourceCancelResponse cancelResponse = new CybersourceCancelResponse();
        cancelResponse.setOrderId(cancelRequest.getOrderId());
        cancelResponse.setStatusCode("CANCELLED");
        return cancelResponse;
    }

    @Override
    public ServiceResponse buildResponse(CybersourceCancelResponse cancelResponse) {
        System.out.println("building ServiceResponse from CybersourceCancelResponse.");
        ServiceResponse serviceResponse = CybersourceTransformers.cancelResponseTransformer().apply(cancelResponse);
        return serviceResponse;
    }

    @Override
    public void save(CybersourceCancelResponse cancelResponse, CybersourceCancelRequest cancelRequest) {
        System.out.println("saving transaction to DB");
    }
}