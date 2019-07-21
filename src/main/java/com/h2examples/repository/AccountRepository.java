package com.h2examples.repository;

import com.h2examples.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRepository extends CrudRepository<Account, Long> { }
