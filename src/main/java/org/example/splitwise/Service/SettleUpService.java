package org.example.splitwise.Service;

import org.example.splitwise.Models.Expense;
import org.example.splitwise.Models.ExpenseUser;
import org.example.splitwise.Models.User;
import org.example.splitwise.Repositorys.ExpenseUserRepository;
import org.example.splitwise.Repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {

    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;

    SettleUpService(UserRepository userRepository,ExpenseUserRepository expenseUserRepository){
        this.userRepository=userRepository;
        this.expenseUserRepository=expenseUserRepository;
    }

    public List<Expense> SettleUpUser(Long userId){

        Optional<User> optionalUser =userRepository.findAllById(userId);

        if (optionalUser.isEmpty()){
            throw new RuntimeException("Invalid uder id "+ userId);
        }

        User user = optionalUser.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        Set<Expense> expenses = new HashSet<>();

        for (ExpenseUser expenseUser:expenseUsers){
            expenses.add(expenseUser.getExpense());
        }



    }
}
