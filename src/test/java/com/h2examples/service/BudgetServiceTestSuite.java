package com.h2examples.service;

import com.h2examples.domain.Budget;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetServiceTestSuite {

    @Autowired
    private BudgetService service;

    @Test
    public void testBudgetService() {
        //Given
        Budget budget = new Budget("Dazz's Budget");

        //When
        Budget savedBudget = service.saveOrUpdate(budget);
        Budget tempBudget = service.getBudget(1L);
        List<Budget> budgets = service.getAllBudgets();

        //Then
        assertNotNull(savedBudget);
        assertNotNull(tempBudget);
        assertEquals("Dazz's Budget", budgets.get(0).getName());
        assertEquals("Dazz's Budget", tempBudget.getName());
    }
}