package com.calculator.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calculator.main.Entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
