package dev.akshaan.ExpenseTracker.service.strategy.settleUpStrategy;

import dev.akshaan.ExpenseTracker.models.Expense;
import dev.akshaan.ExpenseTracker.models.SettlementTransaction;

import java.util.List;

public interface SettleUpStrategy {
    List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses);
}
