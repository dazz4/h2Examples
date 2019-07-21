package com.h2examples.service;

import com.h2examples.domain.Budget;
import com.h2examples.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget saveOrUpdate(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        List<Budget> budgets = new ArrayList<>();
        budgetRepository.findAll().forEach(budgets::add);
        return budgets;
    }

    public Budget getBudget(Long id) {
        return budgetRepository.findById(id).get();
    }

    public void delete(Long id) {
        budgetRepository.deleteById(id);
    }
}
