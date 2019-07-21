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
    public void saveOrUpdate() {
        //Given
        Budget budget = new Budget("Dazz's Budget");

        //When
        service.saveOrUpdate(budget);

        //Then
        assertNotNull(service.getBudget(budget.getId()));


        //CleanUp
        service.delete(budget.getId());
    }

    @Test
    public void getAllBudgets() {
        //Given
        Budget budget1 = new Budget("Dazz's Budget");
        Budget budget2 = new Budget("Peter's Budget");

        //When
        service.saveOrUpdate(budget1);
        service.saveOrUpdate(budget2);
        List<Budget> budgetList = service.getAllBudgets();

        //Then
        assertNotNull(budgetList);
        assertEquals(2, budgetList.size());

        //CleanUp
        service.delete(budget1.getId());
        service.delete(budget2.getId());
    }

    @Test
    public void getBudget() {
        //Given
        Budget budget = new Budget("Dazz's Budget");

        //When
        service.saveOrUpdate(budget);
        Budget tempBudget = service.getBudget(budget.getId());

        //Then
        assertNotNull(tempBudget);
        assertEquals("Dazz's Budget", tempBudget.getName());

        //CleanUp
        service.delete(budget.getId());
    }
}