package dev.akshaan.ExpenseTracker.dtos;

import dev.akshaan.ExpenseTracker.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserAmount {
    private User user;
    private double amount;
}
