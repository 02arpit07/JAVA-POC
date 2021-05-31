package com.example.bct.EcommerceByArpit.services;

import com.example.bct.EcommerceByArpit.entity.*;
import com.example.bct.EcommerceByArpit.repository.*;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class WishListService {

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Autowired
    CustomerRepository customerRepository;

    public void addProductToWishlist(Long customerId, Long productId) {
//        User user = userRepository.findByUserId(userId);
        Product product = productRepository.findByProductId(productId);
        Customer customer = customerRepository.findById(customerId).get();

        if(wishListRepository.findByCustomerAndProduct(customer,product)!=null) {
            WishList wishList = (WishList) wishListRepository.findByCustomerAndProduct(customer,product);
            wishList.setQuantity(wishList.getQuantity()+1);
            wishListRepository.save(wishList);
        }
        else {
            WishList wishList = new WishList();
            wishList.setPricePerUnit(product.getPrice());
            wishList.setProductName(product.getProductName());
            wishList.setProduct(product);
            wishList.setCustomer(customer);
            wishList.setQuantity(1);
            wishListRepository.save(wishList);
        }
    }

    public  String removeProductFromWishList(Long customerId, Long productId) {

        Customer customer = customerRepository.findById(customerId).get();
        Product product = productRepository.findByProductId(productId);
        wishListRepository.deleteAllByCustomerAndProduct(customer,product);
        return "removed";

    }

    public List<WishList> showUserProducts(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return wishListRepository.findByCustomer(customer);
    }


    //Method to decrease quantity of particular product.
    public String subtractProductFromWishList(Long customerId, Long productId) {
        Customer customer = customerRepository.findById(customerId).get();
        Product product = productRepository.findByProductId(productId);

        if(wishListRepository.findByCustomerAndProduct(customer,product)!=null) {
            WishList wishList = (WishList) wishListRepository.findByCustomerAndProduct(customer, product);
            if(wishList.getQuantity()>=2){
                wishList.setQuantity(wishList.getQuantity()-1);
            }
            else if(wishList.getQuantity()==1){
                removeProductFromWishList(customerId,productId);
            }
        }
        return "Decreased quantity successfully";

    }

    public List<OrderHistory> checkout(Principal principal) {
        Customer customer =customerRepository.findByUsername(principal.getName()).get();
        ArrayList<WishList> wishLists = wishListRepository.findAllByCustomer(customer);
        for(WishList wishList : wishLists) {
            OrderHistory orderHistory = new OrderHistory();
            orderHistory.setUserId(wishList.getCustomer().getId());
            orderHistory.setProductQuantity(wishList.getQuantity());
            orderHistory.setProductPrice(wishList.getProduct().getPrice());
            orderHistory.setProductName(wishList.getProduct().getProductName());
            orderHistory.setImage(wishList.getProduct().getImageUrl());
            orderHistory.setProductId(wishList.getProduct().getProductId());
            orderHistory.setOrderDate(new Date());
            orderHistory.setIsDelivered(false);
            wishListRepository.delete(wishList);
            orderHistoryRepository.saveAndFlush(orderHistory);
        }
        return orderHistoryRepository.findAllByUserId(customer.getId());
    }

    public  List<OrderHistory> showOrderHistory(Principal principal) {
        Customer customer = customerRepository.findByUsername(principal.getName()).get();
        return  orderHistoryRepository.findAllByUserId(customer.getId());
    }
}
