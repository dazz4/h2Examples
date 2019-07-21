package com.h2examples.mapper;

import com.h2examples.domain.Account;
import com.h2examples.domain.AccountDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    public Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getBalance(),
                accountDto.getBudget());
    }

    public AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getBalance(),
                account.getBudget());
    }

    public List<AccountDto> mapToAccountDtoList(List<Account> accounts) {
        return accounts.stream()
                .map(account -> new AccountDto(
                        account.getId(),
                        account.getName(),
                        account.getBalance(),
                        account.getBudget()))
                .collect(Collectors.toList());
    }
}
