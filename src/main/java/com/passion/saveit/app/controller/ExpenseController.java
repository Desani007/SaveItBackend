package com.passion.saveit.app.controller;

import com.passion.saveit.app.model.Expense;
import com.passion.saveit.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @GetMapping("/expense")
    @ResponseBody
    public ResponseEntity<List<Expense>> findAll(){
        return new ResponseEntity<>( service.findAll(), HttpStatus.OK);
    }

    @PostMapping ("/expense")
    public ResponseEntity save(@RequestBody Expense expense){
        service.saveExpense(expense);
        return new ResponseEntity(HttpStatus.OK) ;
    }

    @DeleteMapping("/expense/{id}")
    public ResponseEntity delete(@PathVariable long id){
        service.deleteExpense(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PutMapping("/expenses/{id}")
    @ResponseBody
    public  ResponseEntity<Expense> update (@PathVariable long id, @RequestBody Expense expense ){
        return new ResponseEntity<>(service.updateExpense(id,expense),HttpStatus.OK);
    }
    @GetMapping("/expenses/{id}")
    @ResponseBody
    public  ResponseEntity<Expense> findById(@PathVariable long id){
        return new ResponseEntity<>(service.findbyid(id),HttpStatus.OK);
    }
}
