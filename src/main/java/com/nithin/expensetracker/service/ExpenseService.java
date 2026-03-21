package com.nithin.expensetracker.service;

import com.nithin.expensetracker.model.Expense;
import com.nithin.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get expense by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Create new expense
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Update existing expense
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        existing.setTitle(updatedExpense.getTitle());
        existing.setAmount(updatedExpense.getAmount());
        existing.setCategory(updatedExpense.getCategory());
        existing.setDate(updatedExpense.getDate());
        existing.setDescription(updatedExpense.getDescription());

        return expenseRepository.save(existing);
    }

    // Delete expense
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Get expenses by category
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

    // Search expenses by title
    public List<Expense> searchExpenses(String keyword) {
        return expenseRepository.findByTitleContainingIgnoreCase(keyword);
    }
    public List<Expense> filterExpenses(String category, LocalDate from, LocalDate to) {
        return expenseRepository.findByCategoryAndDateRange(category, from, to);
    }
}
