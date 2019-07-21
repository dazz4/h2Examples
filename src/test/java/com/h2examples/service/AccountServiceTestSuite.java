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
    public void testSaveOrUpdate() {
        //Given
        Budget budget = new Budget("Dazz's Budget");
        Account account = new Account("Checking", new BigDecimal(1000), budget);

        //When
        budgetService.saveOrUpdate(budget);
        accountService.saveOrUpdate(account);

        //Then
        assertNotNull(accountService.getAccount(account.getId()));

        //CleanUp
        accountService.delete(account.getId());
    }

    @Test
    public void testGetAllAccouts() {
        //Given
        Budget budget = new Budget("Dazz's Budget");
        Account account1 = new Account("Checking", new BigDecimal(1000), budget);
        Account account2 = new Account("Cash", new BigDecimal(500), budget);

        //When
        budgetService.saveOrUpdate(budget);
        accountService.saveOrUpdate(account1);
        accountService.saveOrUpdate(account2);
        List<Account> accountList = accountService.getAllAccounts();

        //Then
        assertNotNull(accountList);
        assertEquals(2, accountList.size());

        //CleanUp
        //accountService.delete(account1.getId());
        //accountService.delete(account2.getId());
    }

    @Test
    public void testGetAccount() {
        //Given
        Budget budget = new Budget("Dazz's Budget");
        Account account = new Account("Checking", new BigDecimal(1000), budget);

        //When
        budgetService.saveOrUpdate(budget);
        accountService.saveOrUpdate(account);
        Account tempAccount = accountService.getAccount(account.getId());

        //Then
        assertNotNull(tempAccount);

        //CleanUp
        accountService.delete(account.getId());
    }
}