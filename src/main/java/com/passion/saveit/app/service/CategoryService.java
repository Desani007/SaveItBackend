package com.passion.saveit.app.service;

import com.passion.saveit.app.model.Category;
import com.passion.saveit.app.repository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRespository categoryRespository;

    public Category saveCategory(Category category){

        return categoryRespository.save(category);
    }
     public Category updateCatergory(long id,Category updatedCategory){
        Category category = categoryRespository.findById(id).get();
        category.setCategoryName(updatedCategory.getCategoryName());
        categoryRespository.save(category);
        return category;
     }

     public List<Category> findall(){
        return categoryRespository.findAll();
     }

     public void deleteCategory(long id){
        Category category=categoryRespository.findById(id).get();
        categoryRespository.delete(category);
     }
}
