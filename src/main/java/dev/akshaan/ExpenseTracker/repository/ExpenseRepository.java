package dev.akshaan.ExpenseTracker.repository;

import dev.akshaan.ExpenseTracker.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
