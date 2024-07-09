package org.example.splitwise.Repositorys;

import org.example.splitwise.Models.ExpenseUser;
import org.example.splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser ,Long> {



    List<ExpenseUser> findAllByUser(User user);


}
