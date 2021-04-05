package com.example.bct.EcommerceByArpit.services;

import com.example.bct.EcommerceByArpit.entity.Product;
import com.example.bct.EcommerceByArpit.entity.User;
import com.example.bct.EcommerceByArpit.entity.WishList;
import com.example.bct.EcommerceByArpit.repository.ProductRepository;
import com.example.bct.EcommerceByArpit.repository.UserRepository;
import com.example.bct.EcommerceByArpit.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WishListRepository wishListRepository;

    public void addProductToWishlist(Long userId, Long productId) {
        User user = userRepository.findByUserId(userId);
        Product product = productRepository.findByProductId(productId);

        if(wishListRepository.findByUsersAndProduct(user,product)!=null) {
            WishList wishList = (WishList) wishListRepository.findByUsersAndProduct(user,product);
            wishList.setQuantity(wishList.getQuantity()+1);
            wishListRepository.save(wishList);
        }
        else {
            WishList wishList = new WishList();
            wishList.setPricePerUnit(product.getPrice());
            wishList.setProductName(product.getProductName());
            wishList.setProduct(product);
            wishList.setUser(user);
            wishList.setQuantity(1);
            wishListRepository.save(wishList);
        }
    }

    public  String removeProductFromWishList(Long userId, Long productId) {

        User user = userRepository.findByUserId(userId);
        Product product = productRepository.findByProductId(productId);
        wishListRepository.deleteAllByUsersAndProduct(user,product);
        return "removed";

    }

    public List<WishList> showUserProducts(Long userId) {
        User user = userRepository.findByUserId(userId);
        return wishListRepository.findByUsers(user);
    }


    //Method to decrease quantity of particular product.
    public String subtractProductFromWishList(Long userId, Long productId) {
        User user = userRepository.findByUserId(userId);
        Product product = productRepository.findByProductId(productId);

        if(wishListRepository.findByUsersAndProduct(user,product)!=null) {
            WishList wishList = (WishList) wishListRepository.findByUsersAndProduct(user, product);
            if(wishList.getQuantity()>=2){
                wishList.setQuantity(wishList.getQuantity()-1);
            }
            else if(wishList.getQuantity()==1){
                removeProductFromWishList(userId,productId);
            }
        }
        return "Decreased quantity successfully";

    }
}
