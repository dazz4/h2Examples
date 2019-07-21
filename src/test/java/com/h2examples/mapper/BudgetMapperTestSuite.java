package com.h2examples.mapper;

import com.h2examples.domain.Budget;
import com.h2examples.domain.BudgetDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetMapperTestSuite {

    @Autowired
    private BudgetMapper mapper;

    @Test
    public void testMapToBudget() {
        //Given
        BudgetDto budgetDto = new BudgetDto(1L, "Dazz's Budget");

        //When
        Budget budget = mapper.mapToBudget(budgetDto);

        //Then
        assertNotNull(budget);
        assertEquals(Long.valueOf(1), budget.getId());
        assertEquals("Dazz's Budget", budget.getName());
    }

    @Test
    public void testMapToBudgetDto() {
        //Given
        Budget budget = new Budget(1L,"Dazz's Budget");

        //When
        BudgetDto budgetDto = mapper.mapToBudgetDto(budget);

        //Then
        assertNotNull(budgetDto);
        assertEquals(Long.valueOf(1), budgetDto.getId());
        assertEquals("Dazz's Budget", budgetDto.getName());
    }

    @Test
    public void testMapToBudgetDtoList() {
        //Given
        Budget budget = new Budget(1L,"Dazz's Budget");
        List<Budget> budgets = new ArrayList<>();
        budgets.add(budget);

        //When
        List<BudgetDto> budgetDtoList = mapper.mapToBudgetDtoList(budgets);

        //Then
        assertNotNull(budgetDtoList);
        assertEquals(1, budgets.size());
    }
}