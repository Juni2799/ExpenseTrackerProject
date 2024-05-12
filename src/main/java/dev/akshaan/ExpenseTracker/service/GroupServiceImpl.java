package dev.akshaan.ExpenseTracker.service;

import dev.akshaan.ExpenseTracker.models.Expense;
import dev.akshaan.ExpenseTracker.models.Group;
import dev.akshaan.ExpenseTracker.models.SettlementTransaction;
import dev.akshaan.ExpenseTracker.repository.GroupRepository;
import dev.akshaan.ExpenseTracker.service.strategy.settleUpStrategy.MinimumSettlementTransactionStrategy;
import dev.akshaan.ExpenseTracker.service.strategy.settleUpStrategy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    private SettleUpStrategy settleUpStrategy;
    @Autowired
    private GroupRepository groupRepository;

    public GroupServiceImpl() {
        this.settleUpStrategy = new MinimumSettlementTransactionStrategy();
    }

    @Override
    public List<SettlementTransaction> settleUp(int groupId) {
        Group group = groupRepository.findById(groupId).get();
        List<Expense> expenses = group.getExpenses();
        return settleUpStrategy.getSettlementTransactions(expenses);
    }
}
