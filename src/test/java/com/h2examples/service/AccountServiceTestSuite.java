package com.h2examples.service;

import com.h2examples.domain.Account;
import com.h2examples.domain.Budget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTestSuite {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BudgetService budgetService;

    @Test
    public void testAccountService() {
        //Given
        Budget budget = new Budget("Dazz's Budget");
        Account account1 = new Account("Checking", new BigDecimal(1000), budget);
        Account account2 = new Account("Cash", new BigDecimal(500), budget);

        //Then
        budgetService.saveOrUpdate(budget);
        accountService.saveOrUpdate(account1);
        accountService.saveOrUpdate(account2);
        Account tempAccount = accountService.getAccount(1L);
        List<Account> accounts = accountService.getAllAccounts();

        //When
        assertNotNull(tempAccount);
        assertNotNull(accounts);
        assertEquals(2, accounts.size());
        assertEquals("Checking", tempAccount.getName());
    }
}



