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
    
    
    private CartLineInfo findLineById(Long id){
        for(CartLineInfo line : this.cartLines){
            if(line.getProductInfo().getId().equals(id)){
                return line;
            }
        }
        
        return null;
    }
    
    
    public void addProduct(ProductInfo productInfo, int quantity){
    
        CartLineInfo line = this.findLineById(productInfo.getId());
        
        if(line == null){
            line = new CartLineInfo();
            line.setProductInfo(productInfo);
            line.setQuantity(0);
        }
        
        int newQuantity = line.getQuantity() + quantity;
        
        if(newQuantity <= 0){
            this.cartLines.remove(line);
        }else{
            line.setQuantity(newQuantity);
        }
    
    }
    
    
    public void validate(){}
    
    
    
    public void removeProduct(ProductInfo productInfo){
    
        CartLineInfo cartLineInfo = this.findLineById(productInfo.getId());
        
        if(cartLineInfo != null){
            this.cartLines.remove(cartLineInfo);
        }
    }
    
    
    public void updateProduct(Long productId, int quantity){
        
        CartLineInfo cartLineInfo = this.findLineById(productId);
        
        if(cartLineInfo != null){
            if(quantity <= 0){
                this.cartLines.remove(cartLineInfo);
            }else{
                cartLineInfo.setQuantity(quantity);
            }
        }
    
    }
    
    
    public boolean isEmpty(){
        return this.cartLines.isEmpty();
    }
    
    
    public boolean isValidCustomer(){
        return this.customerInfo != null && this.customerInfo.isValid();
    }
    
    
    public int getQuantityTotal(){
        int quantity = 0;
        
        for(CartLineInfo line : this.cartLines){
            quantity += line.getQuantity();
        }
    
    return quantity;
    }
    
    
    public double getAmountTotal(){
        double total = 0;
        
        for(CartLineInfo line : this.cartLines){
            total += line.getAmount();
        }
    return total;
    }
    
    
    public void updateQuantity(CartInfo cartForm){
        if(cartForm != null){
            List<CartLineInfo> lines = cartForm.getCartLines();
            
            for(CartLineInfo line  : lines){
                this.updateProduct(line.getProductInfo().getId(), line.getQuantity());
            }
        }
    }
    
    
    
    
}
