/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceshoppingcartui.util;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 *
 * @author pvargas
 */
public class AuthHeaderFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        
        if(request.getAttribute("AUTH_HEADER") == null){
            String sessionId = UUID.randomUUID().toString();
            
            context.addZuulRequestHeader("AUTH_HEADER", sessionId);
        }
        
        return null;
    }
    
}
