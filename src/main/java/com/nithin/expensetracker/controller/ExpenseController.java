package com.nithin.expensetracker.controller;

import com.nithin.expensetracker.model.Expense;
import com.nithin.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // GET all expenses
    // URL: GET http://localhost:8080/api/expenses
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    // GET expense by ID
    // URL: GET http://localhost:8080/api/expenses/1
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new expense
    // URL: POST http://localhost:8080/api/expenses
    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense created = expenseService.createExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT update expense
    // URL: PUT http://localhost:8080/api/expenses/1
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        Expense updated = expenseService.updateExpense(id, expense);
        return ResponseEntity.ok(updated);
    }

    // DELETE expense
    // URL: DELETE http://localhost:8080/api/expenses/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully!");
    }

    // GET expenses by category
    // URL: GET http://localhost:8080/api/expenses/category/Food
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expense>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(expenseService.getExpensesByCategory(category));
    }

    // GET search expenses
    // URL: GET http://localhost:8080/api/expenses/search?keyword=lunch
    @GetMapping("/search")
    public ResponseEntity<List<Expense>> searchExpenses(@RequestParam String keyword) {
        return ResponseEntity.ok(expenseService.searchExpenses(keyword));
    }
}
