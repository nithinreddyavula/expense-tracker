package com.nithin.expensetracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nithin.expensetracker.model.Expense;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(String category);
    List<Expense> findByTitleContainingIgnoreCase(String keyword);

}
