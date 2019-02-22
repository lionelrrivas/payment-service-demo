package com.usana.paymentservice.transaction;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.model.cybersource.CybersourceRefundRequest;
import com.usana.paymentservice.model.cybersource.CybersourceRefundResponse;

public class CybersourceRefund extends Refund<CybersourceRefundResponse, CybersourceRefundRequest> {
    
    public CybersourceRefund(TransactionSteps<CybersourceRefundResponse, CybersourceRefundRequest> transaction) {
        super(transaction);
    }

    @Override
    public ServiceResponse refund(ServiceRequest serviceRequest) {
        CybersourceRefundRequest refundRequest = transactionSteps.buildRequest(serviceRequest);
        CybersourceRefundResponse refundResponse = transactionSteps.sendRequest(refundRequest);
        ServiceResponse serviceResponse = transactionSteps.buildResponse(refundResponse);
        transactionSteps.save(refundResponse, refundRequest);
        return serviceResponse;
    }
}