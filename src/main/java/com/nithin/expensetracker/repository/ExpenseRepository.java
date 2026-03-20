package com.nithin.expensetracker.repository;

import com.nithin.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find all expenses by category
    List<Expense> findByCategory(String category);

    // Find expenses by title containing keyword
    List<Expense> findByTitleContainingIgnoreCase(String keyword);
}
