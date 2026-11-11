package com.ywshuttle.transport.repository;

import com.ywshuttle.transport.domain.FuelExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelExpenseRepository extends JpaRepository<FuelExpense, Integer> {
}
