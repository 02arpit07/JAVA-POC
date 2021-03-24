package com.example.bct.EcommerceByArpit.controller;

import com.example.bct.EcommerceByArpit.constants.ApiName;
import com.example.bct.EcommerceByArpit.entity.Product;
import com.example.bct.EcommerceByArpit.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.bct.EcommerceByArpit.constants.ApiName.ADMIN;

@RestController
@RequestMapping(value = ADMIN)
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = ApiName.PRODUCT_ADD)
    public Product addProduct(@RequestBody Product product){
        return productService.addOneProduct(product);
    }

    @GetMapping(value = ApiName.PRODUCT_GETALL)
    public List<Product> getAllProduct() {
        return productService.getProductList();
    }

    @GetMapping(value = ApiName.PRODUCT_GET)
    public Optional<Product> getProductById(@PathVariable("id") Long id) {

        return productService.getProduct(id);
    }

    @DeleteMapping(value = ApiName.PRODUCT_DELETE)
    public List<Product> deleteProductById(@PathVariable("id") Long id) {

        return productService.deleteProduct(id);
    }
}
