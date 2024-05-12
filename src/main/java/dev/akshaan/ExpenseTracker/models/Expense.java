package dev.akshaan.ExpenseTracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Expense extends BaseModel{
    private String description;
    private double amount;
    private LocalDateTime dateOfExpense;
    @ManyToOne
    private User addedBy;
    private Currency currency;
    @OneToMany
    private List<UserExpense> userExpenses;
}
