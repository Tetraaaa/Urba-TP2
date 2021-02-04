package org.cnam.sample.repository;

import org.cnam.sample.repository.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
}
