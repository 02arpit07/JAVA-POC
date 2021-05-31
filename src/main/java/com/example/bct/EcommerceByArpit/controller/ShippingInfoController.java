package com.example.bct.EcommerceByArpit.controller;

import com.example.bct.EcommerceByArpit.constants.ApiName;
import com.example.bct.EcommerceByArpit.entity.ShippingInfo;
import com.example.bct.EcommerceByArpit.services.CustomerService;
import com.example.bct.EcommerceByArpit.services.ShippingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.example.bct.EcommerceByArpit.constants.ApiName.COMMON;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = COMMON)
public class ShippingInfoController {

    @Autowired
    ShippingInfoService shippingInfoService;

    @Autowired
    CustomerService customerService;

    @PostMapping(value = ApiName.SHIPPING_INFO_ADD)
    public ShippingInfo addShippingInfo(@RequestBody ShippingInfo shippingInfo, Principal principal){
        return shippingInfoService.addShipping(customerService.getUserId(principal),shippingInfo);
    }

    @GetMapping(value = ApiName.SHIPPING_INFO_GET)
    public ShippingInfo getShippingInfo(Principal principal){
        return shippingInfoService.getShipping(customerService.getUserId(principal));
    }
}
