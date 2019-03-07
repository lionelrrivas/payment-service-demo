package com.usana.paymentservice.model;

import java.util.Objects;

public class ServiceResponse {
    
    private String orderId;
    private String statusCode;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}