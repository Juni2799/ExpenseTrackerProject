package dev.akshaan.ExpenseTracker.service.strategy.settleUpStrategy;

import dev.akshaan.ExpenseTracker.models.Expense;
import dev.akshaan.ExpenseTracker.models.SettlementTransaction;

import java.util.List;

public class MinimumSettlementTransactionStrategy implements SettleUpStrategy{
    @Override
    public List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses) {
        return null;
    }
}
