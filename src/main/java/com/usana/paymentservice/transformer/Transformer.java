package com.usana.paymentservice.transformer;

@FunctionalInterface
public interface Transformer<T, R> {
    
    default R apply(T t) {
        return transform(t);
    }
    
    R transform(T t);
}