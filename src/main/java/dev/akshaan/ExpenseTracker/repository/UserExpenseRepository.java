package dev.akshaan.ExpenseTracker.repository;

import dev.akshaan.ExpenseTracker.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<UserExpense, Integer> {
}
