package dev.akshaan.ExpenseTracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "ET_GROUP")
public class Group extends BaseModel{
    private String name;
    @ManyToOne
    private User createdBy;
    private LocalDateTime createdDate;
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;
    private double totalAmountSpent;
    @OneToMany
    private List<SettlementTransaction> settlementTransactions;
}
