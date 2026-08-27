package com.example.invoicetrackerbackend.dto;

import com.example.invoicetrackerbackend.entity.Invoice;
import java.math.BigDecimal;
import java.util.List;

public record ManagerDashboardDTO(
        BigDecimal totalBudget,
        BigDecimal totalSpent,
        long pendingInvoices,
        long overBudgetCount,
        List<DepartmentBudgetDTO> departmentBudgets,
        List<Invoice> recentInvoices
) {}