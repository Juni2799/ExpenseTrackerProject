package dev.akshaan.ExpenseTracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ET_USER")
public class User extends BaseModel{
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany
    private List<User> friends;
    @ManyToMany
    private List<Group> groups;
}
