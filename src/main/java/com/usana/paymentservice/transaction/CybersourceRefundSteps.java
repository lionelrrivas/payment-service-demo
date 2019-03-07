package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.model.cybersource.CybersourceRefundRequest;
import com.usana.paymentservice.model.cybersource.CybersourceRefundResponse;
import com.usana.paymentservice.transformer.amex.CybersourceTransformers;

public class CybersourceRefundSteps implements TransactionSteps<CybersourceRefundResponse, CybersourceRefundRequest> {

    @Override
    public CybersourceRefundRequest buildRequest(ServiceRequest serviceRequest) {
        System.out.println("building CybersourceRefundRequest from service request.");
        CybersourceRefundRequest refundRequest = CybersourceTransformers
                .refundRequestTransformer()
                .apply(serviceRequest);
        return refundRequest;
    }

    @Override
    public CybersourceRefundResponse sendRequest(CybersourceRefundRequest refundRequest) {
        System.out.println("sending CybersourceRefundRequest to Cybersource.");
        CybersourceRefundResponse refundResponse = new CybersourceRefundResponse();
        refundResponse.setOrderId(refundRequest.getOrderId());
        refundResponse.setStatusCode("REFUNDED");
        return refundResponse;
    }

    @Override
    public ServiceResponse buildResponse(CybersourceRefundResponse refundResponse) {
        System.out.println("building ServiceResponse from CybersourceRefundResponse.");
        ServiceResponse serviceResponse = CybersourceTransformers
                .refundResponseTransformer()
                .apply(refundResponse);
        return serviceResponse;
    }

    @Override
    public void save(CybersourceRefundResponse refundResponse, CybersourceRefundRequest refundRequest) {
        System.out.println("saving transaction to DB");
    }
}