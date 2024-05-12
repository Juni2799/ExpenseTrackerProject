package dev.akshaan.ExpenseTracker.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDTO {
    private String name;
    private String email;
    private String password;
}
