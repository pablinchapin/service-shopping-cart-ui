/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceshoppingcartui.controller;


import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pvargas
 */

@RestController
@Slf4j
//@RequestMapping("/ui")
public class MainController {
    
    private static final String CATALOG_API_URL = "http://catalog-service/api/catalog/";
        
    
    @GetMapping("/403")
    public ModelAndView accessDenied(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("403");
        
        return mav;
    }
    
    
    @GetMapping("/")
    public ModelAndView home(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ){
        
        log.info("MainController");
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        
        //PageRequest pageable = PageRequest
        
        //Page<T> page = 
        
    
    return mav;
    }
    
    
    @GetMapping("/productList")
    public ModelAndView listProductHandler(
            @RequestParam(value = "categoryId", defaultValue="1", required=false) Long categoryId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ){
        
        log.info("productList");
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("productList");
        
        
        return mav;
    }
    
    
    @GetMapping("/productDetail")
    public ModelAndView viewProductHandler(
            HttpServletRequest request,
            @RequestParam(value = "id", defaultValue = "") Long id
    ){
    
        ModelAndView mav = new ModelAndView();
        
        return mav;
    }
    
    
    public ModelAndView shoppingCartHandler(
            HttpServletRequest request
    ){
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("shoppingCart");
        
        
        
    return mav;
    }
    
    
    @GetMapping("/customerOrders")
    public ModelAndView customerOrdersHandler(
            HttpServletRequest request,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("customerOrders");
        
                
        
    return mav;
    }
    
    
    @GetMapping("/customerOrdersDetail")
    public ModelAndView customerOrdersDetailHandler(
            HttpServletRequest request,
            @RequestParam(value = "id", required = true) Long id
    ){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("customerOrdersDetail");
        
        
    return mav;
    }
    
    
    @PostMapping("/shoppingCart")
    public ModelAndView shoppingCartAddProduct(
            HttpServletRequest request,
            @RequestParam(value = "id", defaultValue = "") Long id,
            @RequestParam(value = "quantity", defaultValue = "1") int quantity,
            @RequestParam(value = "action", defaultValue = "add") String action
    ){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("shoppingCart");
        
            
    return mav;
    }
    
    
    @GetMapping("/shoppingCartCheckout")
    public ModelAndView shoppingCartCheckout(
            HttpServletRequest request            
    ){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("shoppingCartCheckout");
        
            
    return mav;
    }
    
    
    @PostMapping("/shoppingCartCheckout")
    public ModelAndView shoppinCartCheckoutHandler(
            HttpServletRequest request,
            
            BindingResult result
    ){
        
        ModelAndView mav = new ModelAndView();
        
        
        
        
        return new ModelAndView("redirect:/shoppingCartConfirmation");
    
    //return mav;
    }
    
    
    @GetMapping("/shoppingCartConfirmation")
    public ModelAndView shoppingCartConfirmation(
            HttpServletRequest request
    ){
        
        ModelAndView mav = new ModelAndView();
        
        
    return mav;
    }
    
    
    @PostMapping("/shoppingCartConfirmation")
    public ModelAndView shoppingCartConfirmationHandler(
            HttpServletRequest request
    ){
        
    
        
    return new ModelAndView("redirect:/shoppingCartFinalize");
    }
    
    
    @GetMapping("/shoppingCartFinalize")
    public ModelAndView shoppingCartFinalize(
            HttpServletRequest request
    ){
        ModelAndView mav = new ModelAndView();
        
        
    return mav;
        
    }
    
    
}
