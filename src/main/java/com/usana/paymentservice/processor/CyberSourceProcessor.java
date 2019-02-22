package com.usana.paymentservice.processor;

import com.usana.paymentservice.model.cybersource.CybersourceAuthRequest;
import com.usana.paymentservice.model.cybersource.CybersourceAuthResponse;
import com.usana.paymentservice.model.cybersource.CybersourceCancelRequest;
import com.usana.paymentservice.model.cybersource.CybersourceCancelResponse;
import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.model.cybersource.CybersourceRefundRequest;
import com.usana.paymentservice.model.cybersource.CybersourceRefundResponse;
import com.usana.paymentservice.transaction.Authorization;
import com.usana.paymentservice.transaction.Cancel;
import com.usana.paymentservice.transaction.Refund;

public class CyberSourceProcessor implements CreditCardPaymentProcessor {

    private final Cancel<CybersourceCancelResponse, CybersourceCancelRequest> cancel;
    private final Authorization<CybersourceAuthResponse, CybersourceAuthRequest> authorization;
    private final Refund<CybersourceRefundResponse, CybersourceRefundRequest> refund;

    public CyberSourceProcessor(Cancel<CybersourceCancelResponse, CybersourceCancelRequest> cancel, 
            Authorization<CybersourceAuthResponse, CybersourceAuthRequest> authorization, 
            Refund<CybersourceRefundResponse, CybersourceRefundRequest> refund) {
        
        this.cancel = cancel;
        this.authorization = authorization;
        this.refund = refund;
    }
    
    @Override
    public ServiceResponse authorizePayment(ServiceRequest serviceRequest) {
        return authorization.authorize(serviceRequest);
    }

    @Override
    public ServiceResponse refundPayment(ServiceRequest serviceRequest) {
        return refund.refund(serviceRequest);
    }

    @Override
    public ServiceResponse cancelPayment(ServiceRequest serviceRequest) {
        return cancel.cancel(serviceRequest);
    }
}