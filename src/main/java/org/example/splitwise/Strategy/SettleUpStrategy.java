package org.example.splitwise.Strategy;

import org.example.splitwise.Models.Expense;

import java.util.List;

public interface SettleUpStrategy {

    List<Expense> SettleUp(List<Expense> expenses);
}
