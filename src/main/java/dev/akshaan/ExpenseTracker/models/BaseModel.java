package dev.akshaan.ExpenseTracker.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
