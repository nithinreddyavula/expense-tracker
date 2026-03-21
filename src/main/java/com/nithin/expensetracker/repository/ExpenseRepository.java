package com.nithin.expensetracker.repository;

import com.nithin.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find all expenses by category
    List<Expense> findByCategory(String category);

    // Find expenses by title containing keyword
    List<Expense> findByTitleContainingIgnoreCase(String keyword);
    //@Query("SELECT e FROM Expense e JOIN FETCH e.category c WHERE c.name = :category AND e.date BETWEEN :from AND :to")
    @Query("SELECT e FROM Expense e WHERE e.category = :category AND e.date BETWEEN :fromDate AND :toDate")
    List<Expense> findByCategoryAndDateRange(
            @Param("category") String category,
            @Param("fromDate") LocalDate from,
            @Param("toDate") LocalDate to
    );
}
