package com.h2examples.mapper;

import com.h2examples.domain.Budget;
import com.h2examples.domain.BudgetDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BudgetMapper {

    public Budget mapToBudget(BudgetDto budgetDto) {
        return new Budget(budgetDto.getId(), budgetDto.getName());
    }

    public BudgetDto mapToBudgetDto(Budget budget) {
        return new BudgetDto(budget.getId(), budget.getName());
    }

    public List<BudgetDto> mapToBudgetDtoList(List<Budget> budgets) {
        return budgets.stream()
                .map(budget -> new BudgetDto(budget.getId(), budget.getName()))
                .collect(Collectors.toList());
    }
}
