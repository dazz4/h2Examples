package com.h2examples.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    public Account(String name, BigDecimal balance, Budget budget) {
        this.name = name;
        this.balance = balance;
        this.budget = budget;
    }
}
