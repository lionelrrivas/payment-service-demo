package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.model.cybersource.CybersourceRefundRequest;
import com.usana.paymentservice.model.cybersource.CybersourceRefundResponse;

public class CybersourceRefundSteps implements TransactionSteps<CybersourceRefundResponse, CybersourceRefundRequest> {

    @Override
    public CybersourceRefundRequest buildRequest(ServiceRequest serviceRequest) {
        System.out.println("building CybersourceRefundRequest from service request.");
        return new CybersourceRefundRequest();
    }

    @Override
    public CybersourceRefundResponse sendRequest(CybersourceRefundRequest r) {
        System.out.println("sending CybersourceRefundRequest to Cybersource.");
        return new CybersourceRefundResponse();
    }

    @Override
    public ServiceResponse buildResponse(CybersourceRefundResponse t) {
        System.out.println("building ServiceResponse from CybersourceRefundResponse.");
        return new ServiceResponse();
    }

    @Override
    public void save(CybersourceRefundResponse t, CybersourceRefundRequest r) {
        System.out.println("saving transaction to DB");
    }
}