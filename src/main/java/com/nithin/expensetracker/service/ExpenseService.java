package com.nithin.expensetracker.service;
import com.nithin.expensetracker.exception.ResourceNotFoundException;
import com.nithin.expensetracker.model.Expense;
import com.nithin.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
    }
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    public void deleteExpense(Long id) {
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        expenseRepository.deleteById(id);
    }
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));

        existing.setTitle(updatedExpense.getTitle());
        existing.setAmount(updatedExpense.getAmount());
        existing.setCategory(updatedExpense.getCategory());
        existing.setDate(updatedExpense.getDate());
        existing.setDescription(updatedExpense.getDescription());

        return expenseRepository.save(existing);
    }public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }
    public List<Expense> searchExpenses(String keyword) {
        return expenseRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
