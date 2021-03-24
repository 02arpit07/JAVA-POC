package com.example.bct.EcommerceByArpit.services;

import com.example.bct.EcommerceByArpit.entity.Category;
import com.example.bct.EcommerceByArpit.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        category.setCreatedOn(new Date());
        category.setUpdatedOn(new Date());
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id){
        List<Category> categList = categoryRepository.findAll();
        Category category=null;
        category = categList.stream().filter(e->e.getCategoryId()==id).findFirst().get();
        return category;
    }

    public List<Category> getAllCategory(){
        List<Category> categoryList= categoryRepository.findAll();
        return categoryList;
    }

    public String deleteCategoryById(Long id){
        List<Category> categList = categoryRepository.findAll();
        Category category=null;
        category = categList.stream().filter(e->e.getCategoryId()==id).findFirst().get();
        categoryRepository.delete(category);
        return "DELETED "+category.getCategoryName();
    }
}
