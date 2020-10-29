package org.cnam.sample.repository;

import org.cnam.sample.repository.model.SampleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleModel, Long> {
}
