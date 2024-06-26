package dev.akshaan.ExpenseTracker.models;

import dev.akshaan.ExpenseTracker.models.constants.UserExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
}
