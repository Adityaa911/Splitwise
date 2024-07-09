package org.example.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.splitwise.Models.Expense;

import java.util.List;

@Getter
@Setter
public class SettleUpResponseDto {
    private List<Expense> expenses;
}
