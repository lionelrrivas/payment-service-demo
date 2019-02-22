package com.usana.paymentservice.demo;

import com.usana.paymentservice.model.ServiceRequest;
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
import com.usana.paymentservice.transaction.CybersourseCancel;
import com.usana.paymentservice.transaction.Refund;
import com.usana.paymentservice.transaction.TransactionSteps;

public class PaymentServiceDemo {
    
    public static void main(String[] args) {
        CreditCardPaymentProcessor paymentProcessor = new CyberSourceProcessor(getCancel(), getAuthorization(), getRefund());
        CreditCardPaymentService paymentService = new CyberSourcePaymentService(paymentProcessor);
        
        paymentService.authorizePayment(new ServiceRequest());
        System.out.println("----------------------------------");
        
        paymentService.refundPayment(new ServiceRequest());
        System.out.println("----------------------------------");
        
        paymentService.cancelPayment(new ServiceRequest());
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
        return new CybersourseCancel(getCancelSteps());
    }
    
    static Refund<CybersourceRefundResponse, CybersourceRefundRequest> getRefund() {
        return new CybersourceRefund(getRefundSteps());
    }
    
    static Authorization<CybersourceAuthResponse, CybersourceAuthRequest> getAuthorization() {
        return new CybersourceAuthorization(getAuthSteps());
    }
}
