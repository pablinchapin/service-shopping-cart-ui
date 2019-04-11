/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceshoppingcartui.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pvargas
 */
public class CartInfo {
    
    private Long orderId;
    private CustomerInfo customerInfo;
    private final List<CartLineInfo> cartLines = new ArrayList<>();

    public CartInfo() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<CartLineInfo> getCartLines() {
        return cartLines;
    }
    
    
    
}
