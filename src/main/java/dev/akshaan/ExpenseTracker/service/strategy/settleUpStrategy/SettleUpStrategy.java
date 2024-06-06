package dev.akshaan.ExpenseTracker.service.strategy.settleUpStrategy;

import dev.akshaan.ExpenseTracker.dtos.SettlementTransactionDTO;
import dev.akshaan.ExpenseTracker.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<SettlementTransactionDTO> getSettlementTransactions(List<Expense> expenses);
}
