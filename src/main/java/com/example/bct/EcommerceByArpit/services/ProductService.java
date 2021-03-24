package com.example.bct.EcommerceByArpit.services;

import com.example.bct.EcommerceByArpit.entity.Product;
import com.example.bct.EcommerceByArpit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product addOneProduct(Product product) {
        Date date=new Date();
        product.setCreatedOn(date);
        product.setUpdatedOn(date);
        return productRepository.saveAndFlush(product);
    }

    public Optional<Product> getProduct(Long id)
    {
        return productRepository.findById(id);
    }

    public List<Product> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

}
