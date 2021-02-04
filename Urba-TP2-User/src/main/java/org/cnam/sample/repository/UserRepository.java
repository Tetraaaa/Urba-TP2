package org.cnam.sample.repository;

import org.cnam.sample.repository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
