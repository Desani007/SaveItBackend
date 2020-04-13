package com.passion.saveit.app.controller;

import com.passion.saveit.app.model.Category;
import com.passion.saveit.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService service;

    @PostMapping("/category")
    @ResponseBody
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(service.saveCategory(category), HttpStatus.OK);
    }
    @PutMapping("/category")
    @ResponseBody
    public ResponseEntity<Category>update(long id, Category category){
        return new ResponseEntity<>(service.updateCatergory(id,category),HttpStatus.OK);

    }
    @GetMapping ("/category")
    @ResponseBody
    public ResponseEntity<List<Category>>  findAllCategory (){
        return new ResponseEntity<>(service.findall(),HttpStatus.OK);
    }

    @DeleteMapping("/cateegory/{id}")
    public ResponseEntity deleteCategory(@RequestParam long id){
        service.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
