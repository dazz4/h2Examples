package com.h2examples.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
    private Long id;
    private String name;
    private BigDecimal balance;
    private Budget budget;
}
