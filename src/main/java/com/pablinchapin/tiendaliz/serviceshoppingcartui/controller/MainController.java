/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.serviceshoppingcartui.controller;



import com.pablinchapin.tiendaliz.serviceshoppingcartui.util.HelperPage;
import com.pablinchapin.tiendaliz.serviceshoppingcartui.util.RestResponsePage;
import java.net.URI;


import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;



import org.springframework.http.HttpMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author pvargas
 */

@RestController
@Slf4j
//@RequestMapping("/ui")
public class MainController {
    
    //private static final String CATALOG_API_URL = "http://catalog-service/api/catalog";
    private static final String CATALOG_API_URL = "http://localhost:8181/api/catalog";
    
    @GetMapping("/403")
    public ModelAndView accessDenied(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("403");
        
        return mav;
    }
    
    
    @GetMapping("/")
    public ModelAndView home(
            //@RequestParam(value = "page", defaultValue = "1") int page,
            //@RequestParam(value = "size", defaultValue = "10") int size
    ){
        
        log.info("MainController");
    
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        
        RestTemplate restTemplate = new RestTemplate();
        String url = CATALOG_API_URL + "/type";
        
        int page = 1;
        int size = 10;
        
        //PageRequest pageable = PageRequest.of(page-1, size);
        
        //ParameterizedTypeReference<RestResponsePage<Example>> ptr = new ParameterizedTypeReference<RestResponsePage<Example>>(){};
        /*
        URI targetUrl =  UriComponentsBuilder.fromUriString(CATALOG_API_URL)
                .path("/type")
                //.queryParam("name", name)
                //.queryParam("page", page) //pageable.getPageNumber()
                //.queryParam("size", size) //pageable.getPageSize()
                //.queryParam("sort", "id") //pageable.getSort()
                .build()
                .toUri();
        */
        //Page<Category> typePage = restTemplate.getForObject(url, typePage<Category.class>);
        //Page<Category> typePage;
        //RestResponsePage<Example> typePage = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
        
        HelperPage typePage = restTemplate.getForObject(url, HelperPage.class);
        
        //PageRequest pageable = PageRequest.of(page -1, size);
        
        mav.addObject("paginationResultCategory", typePage);
        
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
