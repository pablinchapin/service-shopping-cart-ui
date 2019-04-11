/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceshoppingcartui.util;

import com.pablinchapin.tiendaliz.serviceshoppingcartui.model.CartInfo;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pvargas
 */
public class CartUtils {
    
    private final static String CART_ATTRIBUTE_NAME = "newCart";
    private final static String LAST_ORDERED_CART_ATTRIBUTE_NAME = "lastCart";
    
    public static CartInfo getCartInSession(HttpServletRequest request){
        
        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute(CART_ATTRIBUTE_NAME);
        
        if(cartInfo == null){
            cartInfo = new CartInfo();
            
            request.getSession().setAttribute(CART_ATTRIBUTE_NAME, cartInfo);
        }
        
    return cartInfo;
    }
    
    
    public static void removeCartInSession(HttpServletRequest request){
        request.getSession().removeAttribute(CART_ATTRIBUTE_NAME);
    }
    
    
    public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo){
        request.getSession().setAttribute(LAST_ORDERED_CART_ATTRIBUTE_NAME, cartInfo);
    }
    
    
    public static CartInfo getLastOrderedCartInSession(HttpServletRequest request){
        return (CartInfo) request.getSession().getAttribute(LAST_ORDERED_CART_ATTRIBUTE_NAME);
    }
    
}
