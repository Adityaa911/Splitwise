package org.example.splitwise.Service;

import org.example.splitwise.Models.Expense;
import org.example.splitwise.Models.ExpenseUser;
import org.example.splitwise.Models.Group;
import org.example.splitwise.Models.User;
import org.example.splitwise.Repositorys.ExpenseRepository;
import org.example.splitwise.Repositorys.ExpenseUserRepository;
import org.example.splitwise.Repositorys.GroupRepository;
import org.example.splitwise.Repositorys.UserRepository;
import org.example.splitwise.Strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {

    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;

    SettleUpService(SettleUpStrategy settleUpStrategy,ExpenseRepository expenseRepository,GroupRepository groupRepository,UserRepository userRepository,ExpenseUserRepository expenseUserRepository){
        this.userRepository=userRepository;
        this.expenseUserRepository=expenseUserRepository;
        this.settleUpStrategy=settleUpStrategy;
        this.groupRepository=groupRepository;
        this.expenseRepository=expenseRepository;
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

        List<Expense> SettleUpExpenses = settleUpStrategy.SettleUp(expenses.stream().toList());

        List<Expense> settleUpExpensetoReturn = new ArrayList<>();

        for (Expense expense : SettleUpExpenses){
            for (ExpenseUser expenseUser : expense.getExpenseUsers()){
                if (expenseUser.getUser().equals(user)){
                    settleUpExpensetoReturn.add(expense);
                    break;
                }
            }
        }
        return settleUpExpensetoReturn;

    }

    public List<Expense> SettleUpGroup(Long groupId){

        Optional<Group> optionalGroup = groupRepository.findAllById(groupId);

        if (optionalGroup.isEmpty()){
            throw new RuntimeException("this is invalid group" + groupId);
        }

        List<Expense> expenses = expenseRepository.findAllByGroup(optionalGroup.stream().toList());

      //  List<Expense> SettleUpExpenses = settleUpStrategy.SettleUp(expenses);

        return settleUpStrategy.SettleUp(expenses);

    }
}
