package com.example.bct.EcommerceByArpit.controller;

import com.example.bct.EcommerceByArpit.entity.WishList;
import com.example.bct.EcommerceByArpit.services.UserService;
import com.example.bct.EcommerceByArpit.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.bct.EcommerceByArpit.constants.ApiName.COMMON;

@RestController
@RequestMapping(value = COMMON)
public class WishListController {

    @Autowired
    WishListService wishListService;

    @Autowired
    UserService userService;


}
