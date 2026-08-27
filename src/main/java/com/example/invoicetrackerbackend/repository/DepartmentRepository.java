package com.example.invoicetrackerbackend.repository;

import com.example.invoicetrackerbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT COALESCE(SUM(d.budget), 0) FROM Department d")
    BigDecimal calculateTotalCompanyBudget();
}