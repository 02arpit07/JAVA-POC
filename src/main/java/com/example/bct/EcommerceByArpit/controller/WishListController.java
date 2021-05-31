package com.example.bct.EcommerceByArpit.controller;

import com.example.bct.EcommerceByArpit.constants.ApiName;
import com.example.bct.EcommerceByArpit.entity.OrderHistory;
import com.example.bct.EcommerceByArpit.entity.WishList;
import com.example.bct.EcommerceByArpit.services.CustomerService;
import com.example.bct.EcommerceByArpit.services.UserService;
import com.example.bct.EcommerceByArpit.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.example.bct.EcommerceByArpit.constants.ApiName.COMMON;

@RestController
@RequestMapping(value = COMMON)
@CrossOrigin(origins = "*")
public class WishListController {

    @Autowired
    WishListService wishListService;

//    @Autowired
//    UserService userService;
    @Autowired
    CustomerService customerService;


    @PostMapping(ApiName.ADD_TO_CART)
    public String addToCart(@PathVariable("productId") Long productId, Principal principal) {
        System.out.println(principal.getName());
//        System.out.println(productId+"....................");
        wishListService.addProductToWishlist(customerService.getUserId(principal), productId);
        return "\"Added Product To Cart\"";
    }

    @PostMapping(ApiName.SUBTRACT_ONE_FROM_WISHLIST)
    public String subtractProductFromWishList(@PathVariable("productId")Long productId, Principal principal) {
        wishListService.subtractProductFromWishList(customerService.getUserId(principal),productId);
        return "\"removed one product from wishlist\"";
    }

    @PostMapping(ApiName.REMOVE_FROM_CART)
    public String removeFromCart(@PathVariable("productId") Long productId, Principal principal) {
        wishListService.removeProductFromWishList(customerService.getUserId(principal), productId);
        return "\"Product Removed\"";
    }

    //Publically available without user login
    @GetMapping(ApiName.SHOW_CART)
    public List<WishList> showCart(Principal principal) {
        return wishListService.showUserProducts(customerService.getUserId(principal));
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(ApiName.CHECKOUT)
    public List<OrderHistory> checkOutFromCart(Principal principal) {
        return wishListService.checkout(principal);

    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(ApiName.ORDER_HISTORY)
    public List<OrderHistory> showOrderHistory(Principal principal) {
        return wishListService.showOrderHistory(principal);

    }
}
