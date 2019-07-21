package com.h2examples.repository;

import com.h2examples.domain.Budget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BudgetRepository extends CrudRepository<Budget, Long> {}
