package org.example.splitwise.Repositorys;

import org.example.splitwise.Models.Expense;
import org.example.splitwise.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense ,Long> {


    List<Expense> findAllByGroup(List<Group> longs);
}
