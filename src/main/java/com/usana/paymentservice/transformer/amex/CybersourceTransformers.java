package com.usana.paymentservice.transformer.amex;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.model.cybersource.CybersourceAuthRequest;
import com.usana.paymentservice.model.cybersource.CybersourceAuthResponse;
import com.usana.paymentservice.model.cybersource.CybersourceCancelRequest;
import com.usana.paymentservice.model.cybersource.CybersourceCancelResponse;
import com.usana.paymentservice.model.cybersource.CybersourceRefundRequest;
import com.usana.paymentservice.model.cybersource.CybersourceRefundResponse;
import com.usana.paymentservice.transformer.Transformer;

public final class CybersourceTransformers {

    private CybersourceTransformers() {}
    
    public static Transformer<ServiceRequest, CybersourceAuthRequest> authRequestTransformer() {
        return t -> {
            CybersourceAuthRequest cybersourceAuthRequest = new CybersourceAuthRequest();
            cybersourceAuthRequest.setAmount(t.getAmount());
            cybersourceAuthRequest.setCurrencyCode(t.getCurrencyCode());
            cybersourceAuthRequest.setOrderId(t.getOrderId());
            cybersourceAuthRequest.setToken(t.getToken());
            return cybersourceAuthRequest;
        };
    }
    
    public static Transformer<CybersourceAuthResponse, ServiceResponse> authResponseTransformer() {
        return t -> {
            ServiceResponse serviceResponse = new ServiceResponse();
            serviceResponse.setOrderId(t.getOrderId());
            serviceResponse.setStatusCode(t.getStatusCode());
            return serviceResponse;
        };
    }
    
    public static Transformer<ServiceRequest, CybersourceCancelRequest> cancelRequestTransformer() {
        return t -> {
            CybersourceCancelRequest cancelRequest = new CybersourceCancelRequest();
            cancelRequest.setAmount(t.getAmount());
            cancelRequest.setOrderId(t.getOrderId());
            cancelRequest.setCurrencyCode(t.getCurrencyCode());
            return cancelRequest;
        };
    }
    
    public static Transformer<CybersourceCancelResponse, ServiceResponse> cancelResponseTransformer() {
        return t -> {
            ServiceResponse serviceResponse = new ServiceResponse();
            serviceResponse.setOrderId(t.getOrderId());
            serviceResponse.setStatusCode(t.getStatusCode());
            return serviceResponse;
        };
    }
    
    public static Transformer<ServiceRequest, CybersourceRefundRequest> refundRequestTransformer() {
        return t -> {
            CybersourceRefundRequest refundRequest = new CybersourceRefundRequest();
            refundRequest.setAmount(t.getAmount());
            refundRequest.setCurrencyCode(t.getCurrencyCode());
            refundRequest.setOrderId(t.getOrderId());
            return refundRequest;
        };
    }
    
    public static Transformer<CybersourceRefundResponse, ServiceResponse> refundResponseTransformer() {
        return t -> {
            ServiceResponse serviceResponse = new ServiceResponse();
            serviceResponse.setOrderId(t.getOrderId());
            serviceResponse.setStatusCode(t.getStatusCode());
            return serviceResponse;
        };
    }
}