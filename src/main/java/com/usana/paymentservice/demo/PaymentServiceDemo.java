package com.usana.paymentservice.demo;

import com.usana.paymentservice.model.ServiceRequest;
import com.usana.paymentservice.model.ServiceResponse;
import com.usana.paymentservice.model.cybersource.CybersourceAuthRequest;
import com.usana.paymentservice.model.cybersource.CybersourceAuthResponse;
import com.usana.paymentservice.model.cybersource.CybersourceCancelRequest;
import com.usana.paymentservice.model.cybersource.CybersourceCancelResponse;
import com.usana.paymentservice.model.cybersource.CybersourceRefundRequest;
import com.usana.paymentservice.model.cybersource.CybersourceRefundResponse;
import com.usana.paymentservice.processor.CreditCardPaymentProcessor;
import com.usana.paymentservice.processor.CyberSourceProcessor;
import com.usana.paymentservice.service.CreditCardPaymentService;
import com.usana.paymentservice.service.CyberSourcePaymentService;
import com.usana.paymentservice.transaction.Authorization;
import com.usana.paymentservice.transaction.Cancel;
import com.usana.paymentservice.transaction.CybersourceAuthSteps;
import com.usana.paymentservice.transaction.CybersourceAuthorization;
import com.usana.paymentservice.transaction.CybersourceCancelSteps;
import com.usana.paymentservice.transaction.CybersourceRefund;
import com.usana.paymentservice.transaction.CybersourceRefundSteps;
import com.usana.paymentservice.transaction.CybersourceCancel;
import com.usana.paymentservice.transaction.Refund;
import com.usana.paymentservice.transaction.TransactionSteps;

public class PaymentServiceDemo {
    
    public static void main(String[] args) {
        CreditCardPaymentProcessor paymentProcessor = new CyberSourceProcessor(getCancel(), getAuthorization(), getRefund());
        CreditCardPaymentService paymentService = new CyberSourcePaymentService(paymentProcessor);
        
        ServiceResponse authorizePaymentResponse = paymentService.authorizePayment(getServiceRequest());
        System.out.println("auth response = " + authorizePaymentResponse.getOrderId() + ", " + authorizePaymentResponse.getStatusCode());
        System.out.println("----------------------------------");
        
        ServiceResponse refundPaymentResponse = paymentService.refundPayment(getServiceRequest());
        System.out.println("refund response = " + refundPaymentResponse.getOrderId() + ", " + refundPaymentResponse.getStatusCode());
        System.out.println("----------------------------------");
        
        ServiceResponse cancelPaymentResponse = paymentService.cancelPayment(getServiceRequest());
        System.out.println("cancel response = " + cancelPaymentResponse.getOrderId() + ", " + cancelPaymentResponse.getStatusCode());
        System.out.println("----------------------------------");
    }
    
    static TransactionSteps<CybersourceAuthResponse, CybersourceAuthRequest> getAuthSteps() {
        return new CybersourceAuthSteps();
    }
    
    static TransactionSteps<CybersourceCancelResponse, CybersourceCancelRequest> getCancelSteps() {
        return new CybersourceCancelSteps();
    }
    
    static TransactionSteps<CybersourceRefundResponse, CybersourceRefundRequest> getRefundSteps() {
        return new CybersourceRefundSteps();
    }
    
    static Cancel<CybersourceCancelResponse, CybersourceCancelRequest> getCancel() {
        return new CybersourceCancel(getCancelSteps());
    }
    
    static Refund<CybersourceRefundResponse, CybersourceRefundRequest> getRefund() {
        return new CybersourceRefund(getRefundSteps());
    }
    
    static Authorization<CybersourceAuthResponse, CybersourceAuthRequest> getAuthorization() {
        return new CybersourceAuthorization(getAuthSteps());
    }
    
    static ServiceRequest getServiceRequest() {
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setAmount("100.00");
        serviceRequest.setCurrencyCode("USD");
        serviceRequest.setOrderId("123456789");
        serviceRequest.setToken("411111ABCDEF1111");
        return serviceRequest; 
    }
}
