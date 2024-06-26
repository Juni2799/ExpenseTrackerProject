package dev.akshaan.ExpenseTracker.models;

import dev.akshaan.ExpenseTracker.dtos.SettlementTransactionDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
    @ManyToMany(mappedBy = "groups")
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;
    private double totalAmountSpent;
}
