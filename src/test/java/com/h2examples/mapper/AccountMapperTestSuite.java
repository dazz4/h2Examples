package com.h2examples.mapper;

import com.h2examples.domain.Account;
import com.h2examples.domain.AccountDto;
import com.h2examples.domain.Budget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTestSuite {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testMapToAccount() {
        //Given
        Budget budget = new Budget("Dazz's Budget");
        AccountDto accountDto = new AccountDto(
                1L, "Checking", BigDecimal.valueOf(1000), budget);

        //When
        Account account = accountMapper.mapToAccount(accountDto);

        //Then
        assertNotNull(account);
        assertEquals(Long.valueOf(1), account.getId());
        assertEquals("Checking", account.getName());
    }

    @Test
    public void testMapToAccountDto() {
        //Given
        Budget budget = new Budget("Dazz's Budget");
        Account account = new Account(
                1L, "Checking", BigDecimal.valueOf(1000), budget);

        //When
        AccountDto accountDto = accountMapper.mapToAccountDto(account);

        //Then
        assertNotNull(accountDto);
        assertEquals(Long.valueOf(1), accountDto.getId());
        assertEquals("Checking", accountDto.getName());
    }

    @Test
    public void testMapToBudgetDtoList() {
        //Given
        Budget budget = new Budget("Dazz's Budget");
        Account account = new Account(
                1L, "Checking", BigDecimal.valueOf(1000), budget);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);

        //When
        List<AccountDto> accountDtoList = accountMapper.mapToAccountDtoList(accounts);

        //Then
        assertNotNull(accountDtoList);
        assertEquals(1, accounts.size());
    }
}