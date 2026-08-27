package com.example.invoicetrackerbackend.repository;

import com.example.invoicetrackerbackend.entity.Invoice;
import com.example.invoicetrackerbackend.entity.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findTop2ByOrderByCreatedAtDesc();

    long countByStatus(InvoiceStatus status);

    @Query("SELECT COALESCE(SUM(i.amount), 0) FROM Invoice i WHERE i.status = 'APPROVED'")
    BigDecimal calculateTotalSpent();

    @Query("SELECT COALESCE(SUM(i.amount), 0) FROM Invoice i WHERE i.department.id = :departmentId AND i.status = 'APPROVED'")
    BigDecimal calculateDepartmentSpent(@Param("departmentId") Long departmentId);
}