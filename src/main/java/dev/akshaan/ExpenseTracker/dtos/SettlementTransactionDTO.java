package dev.akshaan.ExpenseTracker.dtos;

import dev.akshaan.ExpenseTracker.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Getter
@Setter
public class SettlementTransactionDTO {
    private String borrower;
    private String lender;
    private double amount;

    public SettlementTransactionDTO(User borrower, User lender, double amount) {
        this.borrower = borrower.getName();
        this.lender = lender.getName();
        this.amount = amount;
    }
}
