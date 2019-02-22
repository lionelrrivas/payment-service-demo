/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usana.paymentservice.transformer;

import java.util.function.Function;

/**
 *
 * @author lionelrivas
 */
public interface Transformer<T, R, V> extends Function<T, R> {
    
    default R apply(T t) {
        return transform(t);
    }
    
    R transform(T t);
    
    
}
