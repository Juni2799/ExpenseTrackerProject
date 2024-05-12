package dev.akshaan.ExpenseTracker.controller;

import dev.akshaan.ExpenseTracker.models.SettlementTransaction;
import dev.akshaan.ExpenseTracker.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/settleUp/{groupId}")
    public ResponseEntity settleUp(@PathVariable("groupId") int groupId){
        List<SettlementTransaction> settlementTransactions = groupService.settleUp(groupId);
        return ResponseEntity.ok(settlementTransactions);
    }
}
