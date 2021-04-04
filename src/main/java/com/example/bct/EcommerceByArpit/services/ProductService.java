package com.example.bct.EcommerceByArpit.services;

import com.example.bct.EcommerceByArpit.entity.Category;
import com.example.bct.EcommerceByArpit.entity.Product;
import com.example.bct.EcommerceByArpit.repository.CategoryRepository;
import com.example.bct.EcommerceByArpit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Transactional
    public Product addOneProduct(Product product) {

        Date date=new Date();
//Attempt-1
//        Optional<Category> category1 = categoryRepository.findById(product.getCategory().getCategoryId());
//        if (category1==null){
//            categoryService.addCategoryViaProduct(product.getCategory());
////            String categName = category1.get().getCategoryName();
//
//        }
//        if(category1.isPresent()){
//            categoryService.addCategoryViaProduct(product.getCategory());
//        }

//        Attempt-2
//        Category category1 = new Category();
//        category1.setCategoryId(product.getCategory().getCategoryId());
//        category1.setCategoryName(product.getCategory().getCategoryName());
//        category1.setCategoryImage(product.getCategory().getCategoryImage());
//
//        categoryService.addCategoryViaProduct(category1);


//        boolean category1 = categoryService.isThereAnyCategory(product.getCategory().getCategoryName());
//        System.out.println(category1);
//        if (!category1) {
//            categoryService.addCategoryViaProduct(product.getCategory(),product.getCategory().getCategoryId());
//        }

        Optional<Category> category = categoryRepository.findById(product.getCategory().getCategoryId());
        String categName = category.get().getCategoryName();


        product.setCreatedOn(date);
        product.setUpdatedOn(date);
        product.setCategoryName(categName);
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(Long id)
    {
        return productRepository.findById(id);
    }

    public List<Product> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    public List<Product> getAllProductByCategory(String categoryName) {
        return productRepository.findAllByCategoryName(categoryName);
    }

    public List<Product> getProductsByCategoryAndPrice(String category, Long price1, Long price2) {
        return productRepository.findAllByCategoryNameAndPriceBetween(category, price1, price2);
    }

    public List<Product> getProductsByPrice(Long price1, Long price2) {
        return productRepository.findAllByPriceBetween(price1, price2);
    }



}
