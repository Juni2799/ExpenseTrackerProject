package dev.akshaan.ExpenseTracker.service;

import dev.akshaan.ExpenseTracker.models.User;

public interface UserService {
    User signUp(String name, String email, String password);
}
