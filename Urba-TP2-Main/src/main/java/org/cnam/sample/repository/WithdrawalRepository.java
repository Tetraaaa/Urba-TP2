package org.cnam.sample.repository;

import org.cnam.sample.repository.model.UserModel;
import org.cnam.sample.repository.model.WithdrawalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository<WithdrawalModel, Long> {
}
