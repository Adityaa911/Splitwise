package org.example.splitwise.Strategy;

import org.example.splitwise.Models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> SettleUp(List<Expense> expenses) {
        return List.of();
    }
}
