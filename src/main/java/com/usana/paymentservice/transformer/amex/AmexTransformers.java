package com.usana.paymentservice.transformer.amex;

import com.usana.paymentservice.model.amex.AmexAuthRequest;
import com.usana.paymentservice.model.amex.AmexAuthResponse;
import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.transformer.Transformer;

public class AmexTransformers {
    
    
    public static Transformer<ServiceRequest, AmexAuthRequest> authRequestTransformer() {
        return t -> {
            AmexAuthRequest amexAuthRequest = new AmexAuthRequest();
            amexAuthRequest.setAmount(t.getAmount());
            amexAuthRequest.setCurrency(t.getCurrencyCode());
            amexAuthRequest.setOrderId(t.getOrderId());
            amexAuthRequest.setToken(t.getToken());
            return amexAuthRequest;
        };
    }
    
    public static Transformer<ServiceRequest, AmexAuthResponse> cancelRequestTransformer() {
        return t -> new AmexAuthResponse();
    }
}
