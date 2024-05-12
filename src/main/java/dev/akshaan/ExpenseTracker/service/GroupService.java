package dev.akshaan.ExpenseTracker.service;

import dev.akshaan.ExpenseTracker.models.SettlementTransaction;

import java.util.List;

public interface GroupService {
    List<SettlementTransaction> settleUp(int groupId);
}
