package com.h2examples.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budget_generator")
    @SequenceGenerator(name = "budget_generator", sequenceName = "budget_seq")
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id")
    private List<Account> accounts;

    public Budget(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Budget(String name) {
        this.name = name;
    }
}
