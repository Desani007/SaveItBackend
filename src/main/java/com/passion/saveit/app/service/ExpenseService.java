package com.passion.saveit.app.service;

import com.passion.saveit.app.model.Expense;
import com.passion.saveit.app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public void saveExpense(Expense expense){
         expenseRepository.save(expense);
    }

    public List<Expense> findAll(){
       return expenseRepository.findAll();
    }

    public void deleteExpense(Long id){
       Expense expense= expenseRepository.findById(id).get();
        expenseRepository.delete(expense);
    }

    public Expense updateExpense(Long id, Expense newExpense){
        Expense expense =expenseRepository.findById(id).get();
        expense.setCategory(newExpense.getCategory());
        expense.setDescription(newExpense.getDescription());
        expenseRepository.save(expense);
        return expense;

    }

    public  Expense findbyid(Long id){
        return expenseRepository.findById(id).get();
    }






}
