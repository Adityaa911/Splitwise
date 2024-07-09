package org.example.splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "groupsss")
public class Group extends BaseModel{


    private String Gname;
    private String description;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> members;
    @ManyToOne
    private User createdBy;
    @OneToMany
    private List<Expense> expenses;
}
