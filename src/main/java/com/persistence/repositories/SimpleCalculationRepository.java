package com.persistence.repositories;

import com.persistence.entity.SimpleCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleCalculationRepository extends JpaRepository<SimpleCalculation, Integer> {
}
