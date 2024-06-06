package dev.akshaan.ExpenseTracker.service;

import dev.akshaan.ExpenseTracker.dtos.SettlementTransactionDTO;

import java.util.List;

public interface GroupService {
    List<SettlementTransactionDTO> settleUp(int groupId);
}
